import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params} from "@angular/router";
import {Patient} from "../../shared/models/patient";
import {PatientService} from "../../core/services/patient.service";
import {Diagnosis} from "../../shared/models/diagnosis";
import {Symptom} from "../../shared/models/symptom";
import {DroolsService} from "../../core/services/drools.service";
import {Disease} from "../../shared/models/disease";
import {DiseaseFound} from "../../shared/models/disease_found";
import {Remedy} from "../../shared/models/remedy";
import {RemedyService} from "../../core/services/remedy.service";
import {ToasterConfig, ToasterService} from "angular5-toaster/dist";
import {RemedyPerscription} from "../../shared/models/remedy_prescription";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {DiagnosisModalComponent} from "../diagnosis-modal/diagnosis-modal.component";

@Component({
  selector: 'app-diagnosis',
  templateUrl: './diagnosis.component.html',
  styleUrls: ['./diagnosis.component.css']
})
export class DiagnosisComponent implements OnInit {
  diagnosis: Diagnosis;
  patient: Patient;
  private jmbg: string;
  private symptoms: string;
  diseases : DiseaseFound[];
  diagnosis_determined:Diagnosis;
  remedies :Remedy[];
  remedy : Remedy;
  toasterConfig : ToasterConfig;
  diseaseName: string;
  bsModalRef: BsModalRef;

  constructor(private route: ActivatedRoute, private patientService : PatientService, private droolsService : DroolsService,
              private remedyService : RemedyService, private toasterService: ToasterService, private modalService : BsModalService) {
    this.symptoms = this.diseaseName = '';
    this.route.params.subscribe((param : Params) =>{
        this.jmbg = param['jmbg'];
        this.patientService.getByJmbg(this.jmbg).subscribe(patient =>{
          this.patient = patient;
          console.log(patient);
        });
    });
    this.toasterConfig = new ToasterConfig({timeout: 2000});
  }

  ngOnInit() {
  }

  initializeDiagnosis(){
    this.diagnosis = new Diagnosis('','','', [],  [], 0);
    this.diagnosis.jmbg = this.jmbg;
    let symptoms = this.symptoms.split(',');
    for(let i = 0; i < symptoms.length; i++)
    {
      symptoms[i] = symptoms[i].trim();
      let sy : Symptom = new Symptom('', null);
      let nameValue = symptoms[i].split(':');
      sy.name = nameValue[0];
      if(nameValue.length == 2)
        sy.value = parseInt(nameValue[1]);
      this.diagnosis.symptoms.push(sy);
    }
    this.diagnosis.disease = this.diseaseName;
  }

  disease(){
    this.initializeDiagnosis();

    this.droolsService.getDiesease(this.diagnosis).subscribe(data => {
        this.diagnosis_determined = data;
    });

    this.remedyService.getAll().subscribe(data =>{
      this.remedies = data;
      this.remedy = this.remedies[0];
    });

  }

  addRemedy(){
    if(this.diagnosis.remedy.filter(x => x.name == this.remedy.name).length > 0)
      this.toasterService.pop('error', 'Error', 'The remedy has already been added to the list!');
    else
      this.diagnosis.remedy.push(this.remedy);
  }

  prescribeRemedies(){
    let a = new RemedyPerscription(this.diagnosis_determined.id, this.diagnosis.remedy);
    this.droolsService.prescribe(a).subscribe(data => {

    });
  }

  checkForAllergies(){
    this.droolsService.allergies(this.diagnosis_determined.id).subscribe(x =>{
      if(x.names.length == 0)
        this.toasterService.pop('success', 'OK', 'Pacijent nije alergican!');
      else
        this.toasterService.pop('error', 'Paznja', 'Pacijent je alergican  na remedy!');
    });
  }


  getSymptoms() {
    this.droolsService.symptomsByDisease(this.diseaseName).subscribe(data =>{
        this.bsModalRef = this.modalService.show(DiagnosisModalComponent);
        this.bsModalRef.content.modalRef = this.bsModalRef;
        this.bsModalRef.content.disease = data;
    });
  }

  listDiseases() {
    this.initializeDiagnosis();
    this.droolsService.mostLikely(this.diagnosis).subscribe(data=> {
      this.bsModalRef = this.modalService.show(DiagnosisModalComponent);
      this.bsModalRef.content.modalRef = this.bsModalRef;
      this.bsModalRef.content.diseases = [];
      let dis = data.diseases;
      for (let i = 0 ; i < dis.length; i++)
      this.bsModalRef.content.diseases.push(dis[i]);
    });
  }

  personal() {
    if(this.diseaseName.trim() == '' || this.symptoms.trim() == ''){
      this.toasterService.pop('error', 'error', 'both disease name and symptoms must be entered');
      return;
    }
    this.initializeDiagnosis();
    this.droolsService.personalDiagnosis(this.diagnosis).subscribe(a => console.log(a));
  }

  diseaseHistory(){
    this.bsModalRef = this.modalService.show(DiagnosisModalComponent);
    this.bsModalRef.content.modalRef = this.bsModalRef;
    this.bsModalRef.content.diagnoses = this.patient.diagnosis;
  }
}

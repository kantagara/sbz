import { Component, OnInit } from '@angular/core';
import {Patient} from "../../shared/models/patient";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {PatientService} from "../../core/services/patient.service";
import {PatientModalComponent} from "../patient-modal/patient-modal.component";

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  patients : Array<Patient>;
  modalRef: BsModalRef;
  patient : Patient;

  constructor(private patientService: PatientService,  private modalService : BsModalService) {
    patientService.getAll().subscribe(data => this.patients = data);
    this.patient = new Patient('', '', '', [], [], []);
  }

  ngOnInit() {
  }



  add(){
    this.modalRef = this.modalService.show(PatientModalComponent);
    this.modalRef.content.modalRef = this.modalRef;
    this.patient = new Patient('', '', '', [], [], []);
    this.modalRef.content.change = false;
    this.modalRef.content.remedy = this.patient;
    this.modalRef.content.save.subscribe(data =>{
      this.patientService.add(data).subscribe(d => this.patients.push(new Patient(this.patient.name,
        this.patient.surname, this.patient.jmbg, this.patient.allergicToRemedy, this.patient.allergicToIngredient,
        this.patient.diagnosis)));
    });
  }

  change(remedy : Patient){
    this.modalRef = this.modalService.show(PatientModalComponent);
    this.modalRef.content.modalRef = this.modalRef;
    this.modalRef.content.change = true;
    this.modalRef.content.patient = remedy;
    this.modalRef.content.save.subscribe(data =>{
      this.patientService.change(remedy).subscribe(d => console.log(d));
    });
  }

  delete(remedy){
    this.patientService.delete(remedy.jmbg).subscribe(data =>{
      let index = this.patients.indexOf(remedy);
      this.patients.splice(index, 1);
    });
  }
}

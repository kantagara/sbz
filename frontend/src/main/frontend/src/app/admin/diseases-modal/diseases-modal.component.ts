import { Component, OnInit, EventEmitter } from '@angular/core';
import {Disease} from "../../shared/models/disease";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {DiseaseService} from "../../core/services/disease.service";
import {Symptom} from "../../shared/models/symptom";
import {SymptomService} from "../../core/services/symptom.service";

@Component({
  selector: 'app-diseases-modal',
  templateUrl: './diseases-modal.component.html',
  styleUrls: ['./diseases-modal.component.css']
})
export class DiseasesModalComponent implements OnInit {

  disease: Disease;
  save: EventEmitter<Disease> = new EventEmitter();
  modalRef: BsModalRef;
  change: boolean;
  symptoms: Array<Symptom>;
  selectedValueGeneral :Symptom;
  selectedValueSpecific : Symptom;
  selectedValueSymptom: Symptom;


  constructor(private modalService : BsModalService, private symptomService : SymptomService) {
    this.symptomService.getAll().subscribe(data => {
        this.symptoms = data;
      this.selectedValueSymptom = this.symptoms[0];
    });
    this.disease = new Disease('', [], []);

  }

  ngOnInit() {
  }

  deleteFromArray(array : Array<Symptom>, name : string){

    for(let i = 0; i < array.length; i++)
    {
      if(array[i].name == name){
        array.splice(i, 1);
        return;
      }
    }
  }

  addToArray(array : Array<Symptom>){
    if(this.selectedValueSymptom == ''){
      alert("None value has been selected");
      return;
    }

    if(this.disease.general.some(e => e.name == this.selectedValueSymptom.name) || this.disease.specific.some(e => e.name == this.selectedValueSymptom.name)){
      alert("Value has already been added to the symptoms list");
      return;
    }
    console.log(this.selectedValueSymptom);
    array.push(this.symptoms.find(obj => obj.name == this.selectedValueSymptom.name));
  }


  send() {
    this.save.emit(this.disease);
    this.modalRef.hide();
  }

}

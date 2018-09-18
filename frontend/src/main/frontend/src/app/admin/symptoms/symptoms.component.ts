import { Component, OnInit } from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Symptom} from "../../shared/models/symptom";
import {SymptomService} from "../../core/services/symptom.service";
import {SymptomsModalComponent} from "../symptoms-modal/symptoms-modal.component";

@Component({
  selector: 'app-symptoms',
  templateUrl: './symptoms.component.html',
  styleUrls: ['./symptoms.component.css']
})
export class SymptomsComponent implements OnInit {

  symptoms : Array<Symptom>;
  symptom : Symptom;
  modalRef : BsModalRef;

  constructor(private symptomService : SymptomService,  private modalService : BsModalService) {
    this.symptomService.getAll().subscribe(data => this.symptoms = data);
  }

  ngOnInit() {
  }

  add(){
    this.symptom = new Symptom('', 0);
    this.modalRef = this.modalService.show(SymptomsModalComponent);
    this.modalRef.content.symptom = this.symptom;
    this.modalRef.content.modalRef = this.modalRef;
    this.modalRef.content.change = false;
    this.modalRef.content.save.subscribe(data => this.symptomService.add(this.symptom).subscribe(data =>{
      this.symptoms.push(new Symptom(this.symptom.name, this.symptom.value));
    }));
  }

  change(symptom : Symptom){
    this.modalRef = this.modalService.show(SymptomsModalComponent);
    this.modalRef.content.symptom = symptom;
    this.modalRef.content.modalRef = this.modalRef;
    this.modalRef.content.change = true;
    this.modalRef.content.save.subscribe(data => this.symptomService.change(symptom).subscribe(data =>{

    }));
  }

  delete(symptom : Symptom){
    return this.symptomService.delete(symptom.name).subscribe(data =>{
      let index = this.symptoms.indexOf(symptom);
      this.symptoms.splice(index, 1);
    })
  }

}

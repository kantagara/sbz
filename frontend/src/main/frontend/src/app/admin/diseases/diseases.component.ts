import { Component, OnInit } from '@angular/core';
import {Disease} from "../../shared/models/disease";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {DiseasesModalComponent} from "../diseases-modal/diseases-modal.component";
import {DiseaseService} from "../../core/services/disease.service";

@Component({
  selector: 'app-diseases',
  templateUrl: './diseases.component.html',
  styleUrls: ['./diseases.component.css']
})
export class DiseasesComponent implements OnInit {

  disease : Disease;
  diseases : Disease[];
  modalRef: BsModalRef;


  constructor(private modalService : BsModalService, private diseaseService : DiseaseService) {
    this.diseaseService.getAll().subscribe(data => {
    this.diseases = data;
    });
  }

  ngOnInit() {
  }

  add(){
    this.disease = new Disease('', [], []);
    this.modalRef = this.modalService.show(DiseasesModalComponent);
    this.modalRef.content.symptom = this.disease;
    this.modalRef.content.modalRef = this.modalRef;
    this.modalRef.content.change = false;
    this.modalRef.content.save.subscribe(data => this.diseaseService.add(data).subscribe(data =>{
      this.diseases.push(new Disease(this.disease.name, this.disease.general, this.disease.specific));
    }));
  }

  change(symptom : Disease){
    this.modalRef = this.modalService.show(DiseasesModalComponent);
    this.modalRef.content.disease = symptom;
    console.log(symptom);
    if(symptom.general.length > 0) {
      this.modalRef.content.selectedValueGeneral = symptom.general[0];
      console.log(this.modalRef.content.selectedValueGeneral);
    }
    if(symptom.specific.length > 0)
    this.modalRef.content.selectedValueSpecific = symptom.specific[0];
    this.modalRef.content.modalRef = this.modalRef;
    this.modalRef.content.change = true;
    this.modalRef.content.save.subscribe(data => this.diseaseService.change(symptom).subscribe(data =>{

    }));
  }

  delete(symptom : Disease){
    return this.diseaseService.delete(symptom.name).subscribe(data =>{
      let index = this.diseases.indexOf(symptom);
      this.diseases.splice(index, 1);
    })
  }

}

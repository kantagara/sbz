import { Component, OnInit, EventEmitter } from '@angular/core';
import {Patient} from "../../shared/models/patient";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {RemedyService} from "../../core/services/remedy.service";
import {Remedy} from "../../shared/models/remedy";

@Component({
  selector: 'app-patient-modal',
  templateUrl: './patient-modal.component.html',
  styleUrls: ['./patient-modal.component.css']
})
export class PatientModalComponent implements OnInit {

  patient: Patient;
  save: EventEmitter<Patient> = new EventEmitter();
  modalRef: BsModalRef;
  change: boolean;
  ingredients : string[];
  remedies: Remedy[];
  selectedValuePatientIngredient:string;
  selectedValuePatientRemedy:string;
  selectedValueIngredient:string;
  selectedValueRemedy:Remedy;

  constructor(private modalService : BsModalService, private remedyService: RemedyService) {
    this.patient = new Patient('', '', '', [], [], []);

    this.remedyService.getAllIngerdients().subscribe(data =>{
      this.ingredients= data;
      this.selectedValueIngredient = this.ingredients[0];
    });
    this.remedyService.getAll().subscribe(data => {
      this.remedies = data;
      this.selectedValueRemedy = this.remedies[0];
    });
  }

  ngOnInit() {
  }



  send() {
    this.save.emit(this.patient);
    this.modalRef.hide();
  }

  addIngredientsToAllergyList() {
    if(this.patient.allergicToIngredient.filter(e => e == this.selectedValueIngredient).length > 0)
    {
      alert("This Item is already in the list");
      return;
    }

    this.patient.allergicToIngredient.push(this.selectedValueIngredient);

    if(this.patient.allergicToIngredient.length == 1)
      this.selectedValuePatientIngredient = this.patient.allergicToIngredient[0];
  }

  addRemedyToAllergyList() {
    if(this.patient.allergicToRemedy.filter(e => e == this.selectedValueRemedy.name).length > 0)
    {
      alert("This Item is already in the list");
      return;
    }

    this.patient.allergicToRemedy.push(this.selectedValueRemedy.name);
    if(this.patient.allergicToRemedy.length == 1)
      this.selectedValuePatientRemedy = this.patient.allergicToRemedy[0];
  }

  removeItemFromList(array : Array<string>, item : string){
    let index = array.indexOf(item);
    array.splice(index, 1);
  }
}

import { Component, OnInit,EventEmitter } from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Remedy} from "../../shared/models/remedy";

@Component({
  selector: 'app-remedies-modal',
  templateUrl: './remedies-modal.component.html',
  styleUrls: ['./remedies-modal.component.css']
})
export class RemediesModalComponent implements OnInit {

  remedy: Remedy;
  save: EventEmitter<Remedy> = new EventEmitter();
  modalRef: BsModalRef;
  change: boolean;
  types: Array<string>;
  selectedValue : string;
  ingredients : string;

  constructor(private modalService : BsModalService) {
    this.types = [  "ANTIBIOTIK",
      "ANELGETIK",
      "OSTALO"];

    this.selectedValue = this.types[0];
    this.remedy = new Remedy('', [],'');
  }

  ngOnInit() {
  }

  splitIngredients(){
    let arr = this.ingredients.split(',');
    for(let i = 0; i < arr.length; i++)
      arr[i] = arr[i].trim();

    return arr;
  }

  send() {
    this.remedy.remedyType = this.selectedValue;
    this.remedy.ingredients = this.splitIngredients();
    this.save.emit(this.remedy);
    this.modalRef.hide();
  }
}

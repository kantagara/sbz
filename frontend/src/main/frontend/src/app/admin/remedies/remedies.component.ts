import { Component, OnInit } from '@angular/core';
import {RemedyService} from "../../core/services/remedy.service";
import {Remedy} from "../../shared/models/remedy";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {RemediesModalComponent} from "../remedies-modal/remedies-modal.component";

@Component({
  selector: 'app-remedies',
  templateUrl: './remedies.component.html',
  styleUrls: ['./remedies.component.css']
})
export class RemediesComponent implements OnInit {

  remedies : Array<Remedy>;
  modalRef: BsModalRef;
  ingredients: string;
  remedy : Remedy;

  constructor(private remedyService: RemedyService,  private modalService : BsModalService) {
    remedyService.getAll().subscribe(data => this.remedies = data);
    this.remedy = new Remedy('', [], '');
  }

  ngOnInit() {
  }

  appendAllIngredients(remedy : Remedy){
      let sb : string = "";
      console.log(remedy);
      for(let i = 0; i < remedy.ingredients.length; i++)
        sb += remedy.ingredients[i] + (i != remedy.ingredients.length - 1 ? ", " : "");

      return sb;
  }

  add(){
    this.modalRef = this.modalService.show(RemediesModalComponent);
    this.modalRef.content.modalRef = this.modalRef;
    this.remedy = new Remedy('', [], '');
    this.modalRef.content.change = false;
    this.modalRef.content.remedy = this.remedy;
    this.modalRef.content.save.subscribe(data =>{
      this.remedyService.add(data).subscribe(d => this.remedies.push(new Remedy(this.remedy.name, this.remedy.ingredients, this.remedy.remedyType)));
    });
  }

  change(remedy){
    this.modalRef = this.modalService.show(RemediesModalComponent);
    this.modalRef.content.modalRef = this.modalRef;
    this.modalRef.content.change = true;
    this.modalRef.content.remedy = remedy;
    this.modalRef.content.ingredients = this.appendAllIngredients(remedy);
    this.modalRef.content.save.subscribe(data =>{
      this.remedyService.change(remedy).subscribe(d => console.log(d));
    });
  }

  delete(remedy){
    this.remedyService.delete(remedy.name).subscribe(data =>{
        let index = this.remedies.indexOf(remedy);
        this.remedies.splice(index, 1);
    });
  }

}

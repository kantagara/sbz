import { Component, OnInit, EventEmitter } from '@angular/core';
import {Symptom} from "../../shared/models/symptom";
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-symptoms-modal',
  templateUrl: './symptoms-modal.component.html',
  styleUrls: ['./symptoms-modal.component.css']
})
export class SymptomsModalComponent implements OnInit {

  symptom: Symptom;
  save: EventEmitter<Symptom> = new EventEmitter();
  modalRef: BsModalRef;
  change: boolean;

  constructor(private modalService : BsModalService) {
    this.symptom = new Symptom('', 0);
  }

  ngOnInit() {
  }


  send() {
    this.save.emit(this.symptom);
    this.modalRef.hide();
  }

}

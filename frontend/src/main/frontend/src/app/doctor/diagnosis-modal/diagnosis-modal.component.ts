import { Component, OnInit } from '@angular/core';
import {Remedy} from "../../shared/models/remedy";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Diagnosis} from "../../shared/models/diagnosis";
import {Disease} from "../../shared/models/disease";

@Component({
  selector: 'app-diagnosis-modal',
  templateUrl: './diagnosis-modal.component.html',
  styleUrls: ['./diagnosis-modal.component.css']
})
export class DiagnosisModalComponent implements OnInit {

  public disease : Disease;
  modalRef : BsModalRef;
  diagnosis: Diagnosis;
  diseases : any[];
  diagnoses: Diagnosis[];

  constructor(bsModalService : BsModalService) { }

  ngOnInit() {
  }

}

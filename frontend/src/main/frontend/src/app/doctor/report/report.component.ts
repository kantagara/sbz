import { Component, OnInit } from '@angular/core';
import {DroolsService} from "../../core/services/drools.service";
import {Patient} from "../../shared/models/patient";
import {BadRequestError} from "../../shared/errors/bad-request-error";
import {ToasterConfig, ToasterService} from "angular5-toaster/dist";

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  patients : Patient[];
  toasterConfig : ToasterConfig;
  constructor(private droolsService : DroolsService, private toasterService:  ToasterService) {
    this.toasterConfig = new ToasterConfig({timeout: 4000});
  }

  ngOnInit() {
  }

  chronically(){
    return this.droolsService.chronically().subscribe(data => {
      this.patients = data.patients;
    }, error2 => {
      if(error2.status == 400)
        this.toasterService.pop('error', 'Error', 'No chronically ill patient was found!');
    })
  }

  addictions() {
    return this.droolsService.addictions().subscribe(data => {
      this.patients = data.patients;
    }, error2 => {
      if(error2.status == 400)
        this.toasterService.pop('error', 'Error', 'No patient with addiction was found!');
    })
  }

  lowImmunity() {
    return this.droolsService.immunity().subscribe(data => {
      this.patients = data.patients;
    }, error2 => {
      if(error2.status == 400)
        this.toasterService.pop('error', 'Error', 'No patient with low immunity was found!');
    })
  }
}

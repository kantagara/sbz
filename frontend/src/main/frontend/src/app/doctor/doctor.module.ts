import { NgModule } from '@angular/core';
import { DiagnosisComponent } from './diagnosis/diagnosis.component';
import { PatientComponent } from './patient/patient.component';
import {DoctorRouterModule} from "./doctor-router.module";
import {SharedModule} from '../shared/shared.module';
import {ToasterModule} from "angular5-toaster/dist";
import {FormsModule} from "@angular/forms";
import {CoreModule} from "../core/core.module";
import { PatientModalComponent } from './patient-modal/patient-modal.component';
import {CommonModule} from "@angular/common";
import { ReportComponent } from './report/report.component';
import { DiagnosisModalComponent } from './diagnosis-modal/diagnosis-modal.component';

@NgModule({
  imports: [
    CoreModule,
    SharedModule,
    CommonModule,
    DoctorRouterModule,
    ToasterModule,
    FormsModule
  ],
  declarations: [DiagnosisComponent, PatientComponent, PatientModalComponent, ReportComponent, DiagnosisModalComponent],
  entryComponents: [PatientModalComponent, DiagnosisModalComponent]
})
export class DoctorModule { }

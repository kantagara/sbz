import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {DiagnosisComponent} from "./diagnosis/diagnosis.component";
import {PatientComponent} from "./patient/patient.component";
import {ReportComponent} from "./report/report.component";

// component

const routes: Routes = [
  { path: 'patient', component: PatientComponent },
  { path: 'diagnosis/:jmbg', component: DiagnosisComponent},
  { path: 'report', component: ReportComponent},
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class DoctorRouterModule { }

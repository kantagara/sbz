import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {UserComponent} from "./user/user.component";
import {DiseasesComponent} from "./diseases/diseases.component";
import {RemediesComponent} from "./remedies/remedies.component";
import {SymptomsComponent} from "./symptoms/symptoms.component";
// component

const routes: Routes = [
  { path: '', component: UserComponent },
  { path: 'disease', component: DiseasesComponent},
  { path: 'remedy', component: RemediesComponent},
  { path: 'symptom', component: SymptomsComponent}
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class AdminRouterModule { }

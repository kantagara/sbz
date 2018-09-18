import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {SharedModule} from "../shared/shared.module";
import {AdminRouterModule} from "./admin-router.module";
import {ToasterModule} from "angular5-toaster/dist";
import { UserComponent } from './user/user.component';
import {SymptomsComponent} from "./symptoms/symptoms.component";
import {DiseasesComponent} from "./diseases/diseases.component";
import {RemediesComponent} from "./remedies/remedies.component";
import { UserModalComponent } from './user-modal/user-modal.component';
import {FormsModule} from "@angular/forms";
import { SymptomsModalComponent } from './symptoms-modal/symptoms-modal.component';
import { RemediesModalComponent } from './remedies-modal/remedies-modal.component';
import { DiseasesModalComponent } from './diseases-modal/diseases-modal.component';


@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    AdminRouterModule,
    ToasterModule,
    FormsModule
  ],
  declarations: [
    UserComponent,
    SymptomsComponent,
    DiseasesComponent,
    RemediesComponent,
    UserModalComponent,
    SymptomsModalComponent,
    RemediesModalComponent,
    DiseasesModalComponent
  ],
  entryComponents: [
    UserModalComponent,
    RemediesModalComponent,
    SymptomsModalComponent,
    DiseasesModalComponent
  ]
})
export class AdminModule { }

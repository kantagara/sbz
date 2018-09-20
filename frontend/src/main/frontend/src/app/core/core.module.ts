import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AdminGuard} from "./guards/admin.guard";
import {DoctorGuard} from "./guards/doctor.guard";
import {AnonymousGuard} from "./guards/anonymous.guard";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers:[AdminGuard, DoctorGuard, AnonymousGuard]
})
export class CoreModule { }

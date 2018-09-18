import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AdminGuard} from "./guards/admin.guard";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [],
  providers:[AdminGuard]
})
export class CoreModule { }

import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AnonymousGuard} from "./core/guards/anonymous.guard";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./core/guards/auth.guard";
import {AdminGuard} from "./core/guards/admin.guard";
import {DoctorGuard} from "./core/guards/doctor.guard";

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'admin', loadChildren: 'app/admin/admin.module#AdminModule', canActivate: [AdminGuard]},
  { path: 'doctor', loadChildren: 'app/doctor/doctor.module#DoctorModule', canActivate: [DoctorGuard]},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, {useHash: true})
  ],
  exports: [RouterModule]
})
export class AppRouterModule { }

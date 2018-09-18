import { BrowserModule } from '@angular/platform-browser';
import {ErrorHandler, NgModule} from '@angular/core';


import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './login/login.component';
import {SharedModule} from "./shared/shared.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ToasterModule } from "angular5-toaster/dist";
import {AppRouterModule} from "./app-router.module";
import {CoreModule} from "./core/core.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AppErrorHandler} from "./core/error-handlers/app-error-handler";
import {AuthService} from "./core/services/auth.service";
import {JwtService} from "./core/services/jwt.service";
import {JwtInterceptor} from "./core/interceptors/jwt-interceptor";
import { NavbarComponent } from './navbar/navbar.component';
import {UsersService} from "./core/services/users.service";
import {RemedyService} from "./core/services/remedy.service";
import {SymptomService} from "./core/services/symptom.service";
import {DiseaseService} from "./core/services/disease.service";



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRouterModule,
    SharedModule,
    CoreModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    ToasterModule
  ],
  providers: [{
    provide: ErrorHandler,
    useClass: AppErrorHandler
  }, AuthService,
    JwtService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    }, UsersService, RemedyService, SymptomService, DiseaseService]
  ,
  bootstrap: [AppComponent]
})
export class AppModule { }

import { Injectable } from '@angular/core';
import {Diagnosis} from "../../shared/models/diagnosis";
import {HttpClient} from "@angular/common/http";
import {RemedyPerscription} from "../../shared/models/remedy_prescription";
import {Observable} from "rxjs/Observable";

@Injectable()
export class DroolsService {

  url = "/api/drools";

  constructor(private http : HttpClient) {
  }


  getDiesease(diagnosis : Diagnosis) : Observable<any>{
    return this.http.post(`${this.url}/disease`, diagnosis);
  }

  mostLikely(diagnosis : Diagnosis): Observable<any> {
    return this.http.post(`${this.url}/most_likely`, diagnosis);
  }

  personalDiagnosis(diagnosis: Diagnosis){
    return this.http.post(`${this.url}/personal_diagnosis`, diagnosis);
  }

  symptomsByDisease(name : string){
    return this.http.get(`${this.url}/get_symptoms?name=${name}`);
  }

  prescribe(prescription : RemedyPerscription){
    return this.http.post(`${this.url}/prescribe`, prescription);
  }

  allergies( diagnosis : number): Observable<any>{
      return this.http.get(`${this.url}/allergies?diagnosisId=${diagnosis}`);
  }

  chronically() : Observable<any>{
    return this.http.get(`${this.url}/chronical`);
  }

  addictions() : Observable<any>{
    return this.http.get(`${this.url}/addiction`);
  }

  immunity() : Observable<any>{
    return this.http.get(`${this.url}/immunity`);
  }

}

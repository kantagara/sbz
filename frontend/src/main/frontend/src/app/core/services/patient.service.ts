import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Patient} from "../../shared/models/patient";

@Injectable()
export class PatientService {


  url : string = 'api/patient/';
  constructor(private http: HttpClient) { }


  getAll() : Observable<any>{
    return this.http.get(this.url);
  }

  add(disease: Patient){
    return this.http.post(this.url, disease);
  }

  delete(jmbg: string){
    return this.http.delete(this.url+"?jmbg="+jmbg);
  }

  change(disease: Patient){
    return this.http.put(this.url, disease);
  }

}

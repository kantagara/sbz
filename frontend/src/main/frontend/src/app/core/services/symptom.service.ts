import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Symptom} from "../../shared/models/symptom";

@Injectable()
export class SymptomService {

  url : string = 'api/symptom/';
  constructor(private http: HttpClient) { }


  getAll() : Observable<any>{
    return this.http.get(this.url);
  }

  add(symptom: Symptom){
    return this.http.post(this.url, symptom);
  }

  delete(symptomName: string){
    return this.http.delete(this.url+"?name="+symptomName);
  }

  change(symptom: Symptom){
    return this.http.put(this.url, symptom);
  }

}

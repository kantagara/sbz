import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Disease} from "../../shared/models/disease";

@Injectable()
export class DiseaseService {


  url : string = 'api/disease/';
  constructor(private http: HttpClient) { }


  getAll() : Observable<any>{
    return this.http.get(this.url);
  }

  add(disease: Disease){
    return this.http.post(this.url, disease);
  }

  delete(remedyName: string){
    return this.http.delete(this.url+"?name="+remedyName);
  }

  change(disease: Disease){
    return this.http.put(this.url, disease);
  }


}

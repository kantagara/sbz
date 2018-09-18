import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Remedy} from "../../shared/models/remedy";
import {Observable} from "rxjs/Observable";

@Injectable()
export class RemedyService {

  url : string = 'api/remedy/';
  constructor(private http: HttpClient) { }


  getAll() : Observable<any>{
    return this.http.get(this.url);
  }

  add(remedy: Remedy){
    return this.http.post(this.url, remedy);
  }

  delete(remedyName: string){
    return this.http.delete(this.url+"?name="+remedyName);
  }

  change(remedy: Remedy){
    return this.http.put(this.url, remedy);
  }


}

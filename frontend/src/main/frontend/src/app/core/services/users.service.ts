import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";

@Injectable()
export class UsersService {

  constructor(private http: HttpClient) {

  }

  getAllByRole(role:string): Observable<any>{
    return this.http.get(`api/users/all?role=${role}`);
  }

  register(data: Account, isAdmin: boolean){
    return this.http.post(`api/users/register?isAdmin=${isAdmin}`, data);
  }

  change(data: Account){
    return this.http.put('/api/users/change', data);
  }

  delete(username: string){
    return this.http.delete('/api/users/?username=' + username);
  }

}

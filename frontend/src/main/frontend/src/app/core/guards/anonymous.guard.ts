import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs/Observable';
import {JwtService} from "../services/jwt.service";

@Injectable()
export class AnonymousGuard implements CanActivate {
  constructor(private router: Router, private jwtService: JwtService){}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot){

    if(!(this.jwtService.tokenExist() && !this.jwtService.isTokenExpired()))
        return true;


    this.router.navigate(['logs']);
    return false;
  }
}

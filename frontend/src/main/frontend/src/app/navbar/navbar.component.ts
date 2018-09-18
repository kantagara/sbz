import { Component, OnInit } from '@angular/core';
import {JwtService} from "../core/services/jwt.service";
import {AuthService} from "../core/services/auth.service";

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private jwtService : JwtService, private authService: AuthService) { }

  ngOnInit() {

  }


  logout(){
    this.authService.logout();
  }

}

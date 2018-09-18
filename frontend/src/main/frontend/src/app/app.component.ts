import {AfterViewInit, Component, ElementRef} from '@angular/core';
import {JwtService} from "./core/services/jwt.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {
  ngAfterViewInit(): void {
    this.elementRef.nativeElement.ownerDocument.body.style.backgroundColor = '#f3f3f3';

  }

  title = 'app';

  constructor(private jwtService : JwtService, private elementRef: ElementRef){

  }
}

import { Injectable } from "@angular/core";
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/do';
// service
import { JwtService } from "../services/jwt.service";

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
  constructor(public jwtService: JwtService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if(this.jwtService.tokenExist()) {
      req = req.clone({
        setHeaders: {
          'Authentication-Token': this.jwtService.getToken()
        }
      });
    }

    return next.handle(req);
  }
}

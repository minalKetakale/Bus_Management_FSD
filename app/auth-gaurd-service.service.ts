import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthenticationServiceService } from './authenticaton-service.service';
//import { AuthenticationServiceService } from '../authentication-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGaurdServiceService {
  constructor(private router: Router,
    private authService: AuthenticationServiceService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.authService.isUserLoggedIn())
      return true;

    this.router.navigate(['login']);
    return false;

  }
}
import { Component } from '@angular/core';
import { AuthenticationServiceService } from './authenticaton-service.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = '';
  constructor(public loginService: AuthenticationServiceService) { }

 }

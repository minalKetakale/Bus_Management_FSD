import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './user';
import { map } from 'rxjs/operators';
import { Bus } from './bus';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  private baseURL = "http://localhost:8080/email/";


  constructor(private httpClient: HttpClient) { }
  

  checkEmail(mail:string, bus:Bus):Observable<Object>{
    console.log(mail);
    return this.httpClient.post(`${this.baseURL}?userEmail=${mail}`,bus);
  }

}
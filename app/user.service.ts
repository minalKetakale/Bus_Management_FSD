import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseURL = "http://localhost:8080/users";
  
  
  constructor(private httpClient: HttpClient) { }

  getUsersByBusId(busId: number): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}/bookedUsers/${busId}`);
  }

  addBooking(user: User,busId: number): Observable<Object>{
    console.log("seatbookes");
    return this.httpClient.post<User>(`${this.baseURL}/bookBus/${busId}`,user);
  }

  getUserDetailsById(userID: number): Observable<User>{
    return this.httpClient.get<User>(`${this.baseURL}/getuser/${userID}`);
  }

  deleteUserDetailsById(userID: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/delete/${userID}`);
  }

  getUserList(): Observable<User[]>{
    console.log("userlist");
    return this.httpClient.get<User[]>(`${this.baseURL}`);
  }

}
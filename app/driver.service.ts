import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Driver } from './driver';


@Injectable({
  providedIn: 'root'
})
export class DriverService {

  private baseURL = "http://localhost:8080/Driver";

  constructor(private httpClient: HttpClient) { }

  getDriverDetails(): Observable<Driver[]>{
    return this.httpClient.get<Driver[]>(`${this.baseURL}`);
  }
  
  getDriverList(): Observable<Driver[]>{
    console.log("buslist");
    return this.httpClient.get<Driver[]>(`${this.baseURL}`);
  }

  saveDriverDetails(driver: Driver): Observable<Object>{
    console.log("ndsfj");
    return this.httpClient.post<Driver>(`${this.baseURL}/saveDriver`,driver);
  }

  getDriverDetailsById(driverId: number): Observable<Driver>{
    console.log("driverid");
    return this.httpClient.get<Driver>(`${this.baseURL}/driverbyid/${driverId}`);
  }

  updateDriverDetailsById(driverId: number, driver: Driver): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${driverId}`, driver);
  }

 
  deleteDriverById(driverId: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/delete/${driverId}`);
  }
}

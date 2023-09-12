import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Bus } from './bus';

@Injectable({
  providedIn: 'root'
})
export class BusService {

  private baseURL = "http://localhost:8080/api/v1";

  constructor(private httpClient: HttpClient) { }

  getBusDetails(): Observable<Bus[]>{
    return this.httpClient.get<Bus[]>(`${this.baseURL}`);
  }
  
  getBusList(): Observable<Bus[]>{
    console.log("buslist");
    return this.httpClient.get<Bus[]>(`${this.baseURL}`);
  }

  saveBusDetails(bus: Bus): Observable<Object>{
    console.log("ndsfj");
    return this.httpClient.post<Bus>(`${this.baseURL}/savebus`,bus);
  }

  getBusDetailsById(busId: number): Observable<Bus>{
    return this.httpClient.get<Bus>(`${this.baseURL}/${busId}`);
  }

  updateBusDetailsById(busId: number, bus: Bus): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${busId}`, bus);
  }

 
  deleteBusDetailsById(busId: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${busId}`);
  }

  deleteAllBusDetails (): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}`)
  }

  findByAcDomain(): Observable<Bus[]> {
    console.log("i ca,e here");
    return this.httpClient.get<Bus[]>(`${this.baseURL}/ACBus`);
  }

  findByNonAcDomain(): Observable<Bus[]> {
   console.log("i ca,e to non Veg here");
    return this.httpClient.get<Bus[]>(`${this.baseURL}/nonACBus`);
  }

  findBytravelsName(travellersName:any):Observable<Bus[]>{
    console.log("here");
      return this.httpClient.get<Bus[]>(`${this.baseURL}?name=${travellersName}`);

  
  

      /*findByLocation(loc : string) :Observable<Restaurant[]>{
        console.log(loc);  return this.httpClient.get<Restaurant[]>(`${this.baseURL}/search?location=${loc}`); 
      }    */

      
    }

    findBySourceAndDestination(source : string, destination:string) :Observable<Bus[]>{
      console.log(source,destination); return this.httpClient.get<Bus[]>(`${this.baseURL}/matchRoutes?src=${source}&dest=${destination}`);
    }


    sortByCost(pathVar:string,fieldName:String):Observable<Bus[]>{
      console.log('i am here');
      return this.httpClient.get<Bus[]>(`${this.baseURL}/filter/Price/${pathVar}?price=${fieldName}`);
    }
    
    
    sortByRatings(pathVar:string,fieldName:String):Observable<Bus[]>{
      console.log(pathVar,fieldName);
        return this.httpClient.get<Bus[]>(`${this.baseURL}/filter/Rating/${pathVar}?ratings=${fieldName}`);
       }

       


}



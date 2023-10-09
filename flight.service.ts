import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Flight } from './flight';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  

  private baseURL = "http://localhost:8080/api";

  constructor(private httpClient: HttpClient) { }
  
 
  getFlightById(id : number) : Observable<Flight> {
    return this.httpClient.get<Flight>(`${this.baseURL}/toReadFdId/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}/deleteFd`);
  }

  getFlightList(): Observable<Flight[]>{
    return this.httpClient.get<Flight[]>(`${this.baseURL}/toReadFd`);
  }

  deleteFlight(id : number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/deleteFdId/${id}`);

  }

  findByDomesticFLights(): Observable<Flight[]> {
    return this.httpClient.get<Flight[]>(`${this.baseURL}/isDomestic`);
  }

  findByNonDomesticFLights(): Observable<Flight[]> {
    return this.httpClient.get<Flight[]>(`${this.baseURL}/nonDomestic`);
}

createFlight(flight: Flight): Observable<Object> {
  return this.httpClient.post(`${this.baseURL}/toCreateFd`, flight);
  }
  updateFlight(id : number, flightObj : Flight) : Observable<Flight> {
    return this.httpClient.put<Flight>(`${this.baseURL}/toUpdateFd/${id}`, flightObj);
}
   searchByFlightName(flightName : any) : Observable<Flight[]> {
  return this.httpClient.get<Flight[]>(`${this.baseURL}/getAllFlightDetails/${flightName}`);
}
signin(email:any, password:any):Observable<any>
  {
    const params=new HttpParams().set('email',email).set('password',password);
    console.log(params);
    return this.httpClient.get(`${this.baseURL}/login`,{params});
  }
  sortByFlightRating(direction:string,field:string):Observable<Flight[]> {
    console.log(direction)
    return this.httpClient.get<Flight[]>(`${this.baseURL}/sortByFlightRating/{direction}?fieldName=${field}`);;
  }
  sortByTicketCost(direction:string,field:string):Observable<Flight[]> {
    console.log(direction)
    return this.httpClient.get<Flight[]>(`${this.baseURL}/sortByTicketCost/{direction}?fieldName=${field}`);;
  }
  
}

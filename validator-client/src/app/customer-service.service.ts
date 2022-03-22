import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  private baseUrl: string;
  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/phones/all/'
   }

   public getAll(state: string,country:string){
     return this.http.get(this.baseUrl+"?state="+state+"&country="+country);
   }

}

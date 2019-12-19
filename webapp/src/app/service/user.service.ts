import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { user } from '../user';
import { AuthenticationService } from './authentication.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  httpOptions={
    headers:new HttpHeaders({
      'Content-Type':'application/json'
    }) 
  };
  baseUrl = environment.baseUrl;
  constructor(private httpClient:HttpClient,private authenticationService:AuthenticationService) { }
  addUser(newUser: user) {
    console.log(newUser);
    return this.httpClient.post<any>(this.baseUrl+"/authentication-service/stockmarket/users",newUser);
  }
  updateUser(user:user){
    console.log(user);
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
  return this.httpClient.put<user>(this.baseUrl+"/authentication-service/stockmarket/users",user,httpOptions);
  }
  getUser(userName :any){
    console.log(userName);
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    return this.httpClient.get<any>(this.baseUrl+"/authentication-service/stockmarket/users/"+userName, httpOptions);
  }
}

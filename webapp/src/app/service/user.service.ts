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
  editUserProfile(editUserProfile:any){
    let token = "Bearer " + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    console.log(editUserProfile);
    let userDetails ={
      userName:editUserProfile.userName,
      password:editUserProfile.password,
      email:editUserProfile.email,
    contactNumber:editUserProfile.contactNumber,
    confirmed:editUserProfile.confirmed
    }
    console.log(userDetails);
  return this.httpClient.put<any>(this.baseUrl+"/authentication-service/stockmarket/users",userDetails,httpOptions);
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

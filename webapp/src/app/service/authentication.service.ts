import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  baseUrl = environment.baseUrl;
  private authenticationUrl =  this.baseUrl+"/authentication-service/stockmarket/authentication";
  private token: String;
  private role: String;
  private user: String;
  private confirmed:String;

  constructor(private httpClient: HttpClient) { }
  authenticate(user: String, password: String): Observable<any> {
    let credentials = btoa(user + ":" + password);
    let headers = new HttpHeaders();
    headers = headers.set("Authorization", "Basic " + credentials);
    return this.httpClient.get(this.authenticationUrl, { headers });
  }
  public setToken(token: String) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }
  public setRole(role: String) {
    this.role = role;
  }
  public getRole() {
    return this.role;
  }
  public setUser(user: String) {
    this.user = user;
  }
  public getUser() {
    return this.user;
  }
  public setConfirmed(confirmed: String) {
    this.confirmed = confirmed;
  }
  public getConfirmed() {
    return this.confirmed;
  }
}


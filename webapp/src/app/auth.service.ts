import { Injectable } from '@angular/core';
import { AuthenticationService } from './service/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loggedin: boolean = false;
  //  users: string;
  user: String = null;
  role: String = null;
  

  constructor(private authenticateService: AuthenticationService) { 
    this.loggedin=false;
  }
   currentUser() {
    return this.user;
   }
  
  login(userLoggedIn) {
    this.user = userLoggedIn;
    this.loggedin = true;
  }
  logout() {
    this.user = null;
    this.loggedin = false;
    this.role = null;
    this.authenticateService.setToken(null);
  }
  isloggedin() {
    return this.loggedin;
  }
  setUserName(userInput: String){
    this.user = userInput;
  }
  getUserName(){
    return this.user;
  }
  setRole(role){
    this.role = role;
  }
  getRole(){
    return this.role;
  }
}

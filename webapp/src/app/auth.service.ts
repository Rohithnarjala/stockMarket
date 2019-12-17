import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loggedin: boolean = false;
  user: string;
 // movieId:any;
  constructor() { }
  currentUser() {
    return this.user;
  }
  // setMovieId(id:any){
  //   this.movieId=id;
  // }
  // getMovieId(){
  //   return this.movieId;
  // }
  login(userLoggedIn) {
    this.user = userLoggedIn;
    this.loggedin = true;
  }
  logout() {
    this.user = null;
    this.loggedin = false;
  }
  isloggedin() {
    return this.loggedin;
  }
}

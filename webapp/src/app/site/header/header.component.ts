import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthService, private authenticationService: AuthenticationService) { }

  ngOnInit() {
  }
  logout() {
    this.authenticationService.setToken(null);
    this.authenticationService.setRole(null);
    this.authenticationService.setUser(null);
    this.authService.logout();
  }
  getUser() {
    //console.log(this.authenticationService.getUser());
    return this.authenticationService.getUser();
   
  }
  getRole(){
    return this.authenticationService.getRole();
  }
 
}

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loginError: boolean = false;
  constructor(private authService: AuthService, private authenticationService: AuthenticationService,
    private router: Router, private userService: UserService, private routerActive: ActivatedRoute) { }

  ngOnInit() {
    this.loginForm = new FormGroup({
      'userName': new FormControl(null, [
        Validators.required,
        Validators.minLength(1),
        Validators.maxLength(20)
      ]),
      'password': new FormControl(null, [
        Validators.required
      ])
    });
  }
  error: any;
  login(loginForm: FormGroup) {
    this.authenticationService.authenticate(loginForm.value.userName, loginForm.value.password)
      .subscribe((response) => {
        console.log(response);
        this.authenticationService.setToken(response.token);
        this.authenticationService.setRole(response.role);
        this.authenticationService.setUser(response.user);
        this.authService.login(loginForm.value.userName);

      }, (error) => {
        this.error = "invalid userName/password";
        this.loginError = true;    
  });


} 
}



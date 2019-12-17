import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../service/user.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  editProfileForm: FormGroup;
  userDetails: any;

  constructor(private userService :UserService,private router:ActivatedRoute,private route:Router) { 
    this.editProfileForm=new FormGroup({
      'id':new FormControl("", [Validators.required]),
      'userName':new FormControl("", [Validators.required]),
      'password':new FormControl("", [Validators.required]),
      'email':new FormControl("", [Validators.required]),
      'contactNumber':new FormControl("", [Validators.required, Validators.minLength(10),
        Validators.maxLength(10)]),
      'confirmed':new FormControl("", [Validators.required]),

    })
  }

  ngOnInit() {
    this.router.paramMap.subscribe(params =>{
  console.log(params);
  this.userService.getUser(params.get('userName')).subscribe(response =>{
  console.log(response);
  this.userDetails=response;
  this.editProfileForm = new FormGroup({
    'id':new FormControl(this.userDetails.id, [Validators.required]),
    'userName':new FormControl(this.userDetails.userName, [Validators.required]),
    'password':new FormControl(this.userDetails.password, [Validators.required]),
    'email':new FormControl(this.userDetails.email, [Validators.required]),
    'contactNumber': new FormControl(this.userDetails.contactNumber, [
    Validators.required,
    Validators.minLength(10),
    Validators.maxLength(10)
  ]),
    'confirmed':new FormControl(this.userDetails.confirmed, [Validators.required]),
});
console.log(this.editProfileForm.value);
});
    });
    
  }
  editprofile(editProfileForm:FormGroup){
    this.userService.editUserProfile(editProfileForm.value).subscribe(response =>{
      console.log(response);
    })
  }
}

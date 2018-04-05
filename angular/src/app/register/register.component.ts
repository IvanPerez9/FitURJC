import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ReactiveFormsModule, FormGroup, FormControl } from '@angular/forms';

import { LoginService } from '../login/login.service';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {

  username: string;
  surname: string;
  nickname: string;
  email: string;
  password: string;
  userRegister: FormGroup;
  userSignUp: UserRegister;

  // tslint:disable-next-line:use-life-cycle-interface
  ngOnInit() {
    this.userRegister = new FormGroup({
      username: new FormControl(''),
      surname: new FormControl(''),
      nickname: new FormControl(''),
      email: new FormControl(''),
      password: new FormControl(''),
    });
  }

}

// tslint:disable-next-line:class-name
export interface UserRegister {
  username: string;
  surname: string;
  nickname: string;
  email: string;
  password: string;
}


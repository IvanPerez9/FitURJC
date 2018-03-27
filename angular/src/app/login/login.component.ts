import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from './login.service';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  error_login: boolean;
  loading: boolean;


  constructor(private sessionService: LoginService) {
  }

  logIn(username: string, password: string, event: Event) {
    event.preventDefault(); // Avoid default action for the submit button of the login form
    this.loading = true;

    // Calls service to login user to the api rest
    this.sessionService.logIn(username, password).subscribe(

      user => {
        this.loading = false;

      },
      error => {
        console.error(error);
        this.error_login = true;
      },
    );

  }






}

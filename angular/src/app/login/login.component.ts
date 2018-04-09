import { OnInit } from '@angular/core';
import { Component, ViewEncapsulation } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from './login.service';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class LoginComponent implements OnInit {

  ng4LoadingSpinnerService: any;
  error_login: boolean;
  loading: boolean;
  userLogin: FormGroup;
  userSignIn: UserLogin;
  ngOnInit() {
    this.userLogin = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.minLength(8)]),
      password: new FormControl('', [Validators.required, Validators.minLength(4)]),
    });
  }

  constructor(private userService: UserService, private router: Router) {
  }

  logIn(email: string, password: string) {
    event.preventDefault(); // Avoid default action for the submit button of the login form
    this.loading = true;

    // Calls service to login user to the api rest
  }

  logInTest(email: string, password: string, event: Event) {
    event.preventDefault();
    this.ng4LoadingSpinnerService.show();
    this.error_login = false;
    this.userService.loginUser(email, password).subscribe(result => {
        this.userService.setUserLogged(result);
        this.ng4LoadingSpinnerService.hide();
    }, error => {
        this.error_login = true;
        this.ng4LoadingSpinnerService.hide();
    });
  }

  logOut() {
      this.userService.logOut();
  }

  onSubmit(form: FormGroup) {
    console.log(form.value);
    const valuesForm: any = form.value;
    this.userSignIn = valuesForm;
    this.userService.loginUser(this.userSignIn.email, this.userSignIn.password).subscribe(
      result => {
          this.userService.setUserLogged(result);
          this.router.navigate(['/user/editProfile']);
      },
      error => {
        console.log('Error');
        console.log(error.code);
      });
  }
}

// tslint:disable-next-line:class-name
export interface UserLogin {
  email: string;
  password: string;
}

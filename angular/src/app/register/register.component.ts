import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { passwordValidator } from './passwordValidator';
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
  passwordRepeat: string;
  userRegister: FormGroup;
  userSignUp: UserRegister;

  constructor(private userService: UserService, private router: Router) {
  }

  // tslint:disable-next-line:use-life-cycle-interface
  ngOnInit() {
    this.userRegister = new FormGroup({
      username: new FormControl('', Validators.required),
      surname: new FormControl('', Validators.required),
      nickname: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required ),
      passwordRepeat: new FormControl('', [Validators.required])
    });
  }

  onSubmit(form: FormGroup) {
    console.log(form.value);
    const valuesForm: any = form.value;
    this.userSignUp = valuesForm;
    this.userService.registerUser(this.userSignUp).subscribe(
      result => {
          this.userService.setUserLogged(result);
          this.router.navigate(['/profile']);
      },
      error => {
        console.log('Error');
      });
  }

}

// tslint:disable-next-line:class-name
export interface UserRegister {
  username: string;
  password: string;
  passwordRepeat: string;
  nickname: string;
  email: string;
  surname: string;
}


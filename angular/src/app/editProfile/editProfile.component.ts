import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../login/login.service';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {matchOtherValidator} from "../register/passwordValidator";


@Component({
  // tslint:disable-next-line:component-selector
  selector: 'app-editProfile',
  templateUrl: './editProfile.component.html',
  styleUrls: ['./editProfile.component.css']
})
export class EditProfileComponent implements OnInit {


  public editMode:number; // 0 nada - 1 mail - 2 pass  - 3 registro histórico de metas - 4 imagen
  userUpdated: FormGroup;
  userLogged: User;
  editUser: userUpdated;
  error_updated: boolean;


  constructor(private userService: UserService, private router: Router) {
    this.userLogged = this.userService.getLoggedUser();
    this.editMode = 0;
  }

  ngOnInit() {
    this.userUpdated = new FormGroup({
      name: new FormControl(this.userLogged.name, Validators.required),
      surname: new FormControl(this.userLogged.surname, Validators.required),
      email: new FormControl(this.userLogged.email, Validators.required),
      age: new FormControl(this.userLogged.age, Validators.required)
    });
    console.log("Init UserComponent");
  }

  /*onSubmit(form: FormGroup) {
    console.log(form.value);
    const valuesForm: any = form.value;
    this.userUpdated = valuesForm;
    this.userService.editUser(this.userLogged.id,this.userLogged).subscribe(
      result => {
        this.userService.setUserLogged(result);
        this.router.navigate(['/user/profile']);
      },
    error => {
      console.log(error);
      console.log(error.code);
      /!*if (error.status === 0) {
        this.error_signUp = true;
      } else if (error.status === 401) {
        this.error_signUp = true;
      } else if (error.status === 403) {
        this.error_signUp = true;
      } else if (error.status === 405) {
        this.error_signUp = true;
      }
    });*!/
    });
  }*/

  onSubmit(idUserToEdit: number, form: FormGroup) {
    console.log(form.value);
    console.log(idUserToEdit);
    const valuesForm: any = form.value;
    this.editUser = valuesForm;
    this.userService.editUser(idUserToEdit, this.editUser).subscribe(
      result => {
        console.log(this.editUser);
        console.log(idUserToEdit);
        this.router.navigate(['/']);
      },
      error => {
        console.log(error.code);
      }
    );
  }

}

export interface userUpdated {
  name: string;
  surname: string;
  nickname: string;
  email: string;
  age: number;
}

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
  error_updated: boolean;


  constructor(private userService: UserService, private router: Router) {
    this.userLogged = this.userService.getLoggedUser();
    this.editMode = 0;
  }

  ngOnInit() {
    this.userUpdated = new FormGroup({
      name: new FormControl('', Validators.required),
      surname: new FormControl('', Validators.required),
      nickname: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      age: new FormControl ('', Validators.required),
      passwordHash: new FormControl('', [Validators.required, matchOtherValidator('passwordHash')]),
    });
    console.log("Init UserComponent");
  }
  onSubmit(form:FormGroup){
    console.log("Updating user");
    const newValues: any=form.value;
    this.userUpdated=newValues;

    this.userService.editUser(this.userLogged.id,this.userLogged).subscribe(
      response=> {
        console.log("User edited");
        //Poner alguna comunicacion de que se ha efectuado bien o no la actualizacion
        this.router.navigate(['/user/profile']);

      },
      error => {
        console.log(error);
        console.log(error.code);
        if (error.status === 0) {
          this.error_updated = true;
        } else if (error.status === 401) {
          this.error_updated = true;
        } else if (error.status === 403) {
          this.error_updated = true;
        } else if (error.status === 405) {
          this.error_updated = true;
        }
      });
  }



}

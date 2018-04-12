import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../login/login.service';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';


@Component({
  // tslint:disable-next-line:component-selector
  selector: 'app-editProfile',
  templateUrl: './editProfile.component.html',
  styleUrls: ['./editProfile.component.css']
})
export class EditProfileComponent implements OnInit {

  userLogged: User;
  public editMode:number; // 0 nada - 1 mail - 2 pass  - 3 registro histórico de metas - 4 imagen
  userUpdated: FormGroup;


  constructor(private userService: UserService) {
    this.userLogged = this.userService.getLoggedUser();
    this.editMode = 0;
  }

  ngOnInit() {
    this.userUpdated = new FormGroup({
      username: new FormControl('', [Validators.required, Validators.minLength(4), Validators.maxLength(12)]),
      surname: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      passwordHash: new FormControl('', Validators.required ),
      passwordRepeat: new FormControl('', [Validators.required])
    });
    console.log("Init UserComponent");
  }



}

import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../login/login.service';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'app-editProfile',
  templateUrl: './editProfile.component.html',
  styleUrls: ['./editProfile.component.css']
})
export class EditProfileComponent implements OnInit {

  userLogged: User;
  public editMode:number; // 0 nada - 1 mail - 2 pass  - 3 registro histórico de metas - 4 imagen


  constructor(private userService: UserService) {
    this.userLogged = this.userService.getLoggedUser();
    this.editMode = 0;
  }

  ngOnInit() {
    console.log("Init UserComponent");
  }
  changeEditMode(i:number){
    this.editMode = i;
    this.userLogged.roles =  ['Admin', 'User'];
  }
}

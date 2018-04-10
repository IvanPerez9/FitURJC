import { Component, OnInit } from '@angular/core';
import {UserService} from "./user.service";
import {User} from "./user.model";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  userLogged: User;
  constructor(private userService: UserService) {
    this.userLogged = this.userService.getLoggedUser();
  }

  ngOnInit() {
  }

}

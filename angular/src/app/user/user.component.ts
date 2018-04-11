import { Component, OnInit } from '@angular/core';
import { User } from './user.model';
import { UserService } from '../user/user.service';

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
    console.log("Init UserComponent");
  }

}

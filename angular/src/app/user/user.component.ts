import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
import {UserService} from "./user.service";
import {User} from "./user.model";
=======
import { UserService } from '../user/user.service';
import { Router, ActivatedRoute } from '@angular/router';
>>>>>>> 22a212d22c6f4cebfdd0c52b25017e21ac845d6a

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

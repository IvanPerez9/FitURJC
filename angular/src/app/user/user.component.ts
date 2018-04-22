import { Component, OnInit } from '@angular/core';
import { User } from './user.model';
import { UserService } from '../user/user.service';
import * as globals from "../globals";
import { LoginService } from '../login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  userLogged: User;

  constructor(private userService: UserService, private sessionService: LoginService, private router: Router) {
  
  }

  ngOnInit() {
    this.userLogged = this.userService.getLoggedUser();
    if (this.sessionService.isLogged()) {
          return this.router.navigate(['/user/profile']);
    } else {
      console.log('Not Logged');
      return this.router.navigate(['/login']);
    }
  }

  getUriImage(uriImage: string): string {
    return globals.BASEURL_IMAGE + uriImage;
  }
}

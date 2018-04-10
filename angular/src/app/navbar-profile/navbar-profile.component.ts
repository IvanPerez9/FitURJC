import { Component, OnInit } from '@angular/core';
import { NavbarProfile } from '../navbar-profile/navbar-profile.model';
import { appRoutes } from '../app.routing';
import { LoginService } from '../login/login.service';
<<<<<<< HEAD
import {User} from "../user/user.model";
import {UserService} from "../user/user.service";
=======
import { UserService } from '../user/user.service';
import { Router, ActivatedRoute } from '@angular/router';
>>>>>>> 22a212d22c6f4cebfdd0c52b25017e21ac845d6a

export const LIST_NAVBAR: NavbarProfile[] = [
  { name: 'courses' },
  { name: 'schedule' },
  { name: 'recommendation' }
];
@Component({
  selector: 'app-navbar-profile',
  templateUrl: './navbar-profile.component.html',
  styleUrls: ['./navbar-profile.component.css']
})
export class NavbarProfileComponent implements OnInit {

  listnavbar = LIST_NAVBAR;

  selectedList: NavbarProfile;
<<<<<<< HEAD
  userLogged: User;
  constructor(private router: Router , private loginService: LoginService, private userService:UserService) {
    this.userLogged = this.userService.getLoggedUser();
  }
=======

  constructor(private router: Router , private loginService: LoginService, private userService: UserService) { }
>>>>>>> 22a212d22c6f4cebfdd0c52b25017e21ac845d6a

  ngOnInit() {
  }

  onSelect(navbar: NavbarProfile): void {
    this.selectedList = navbar;
  }

  navigateTo (linkRouter: string): string {
    for (let rout of appRoutes) {
      if ((linkRouter === rout.path)) {
        return '/' + linkRouter; /*SOLO SE PUEDE IR A COURSES (EXTERNAMENTE)*/
      }
    }
    return '/user/profile/#' + linkRouter;
  }

  showIfAdmin() {
    if (this.loginService.isAdmin() === true) {
        console.log('logeado admin');
        return true;
    } else {
      console.log('false');
        return false;
    }
  }

<<<<<<< HEAD
  onLoggedout(){
=======
  onLoggedout() {
>>>>>>> 22a212d22c6f4cebfdd0c52b25017e21ac845d6a
    this.userService.logOut();
    this.router.navigate(['/']);
  }
}

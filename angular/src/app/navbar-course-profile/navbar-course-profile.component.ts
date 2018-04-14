import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { UserService } from '../user/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../user/user.model';

@Component({
  selector: 'app-navbar-course-profile',
  templateUrl: './navbar-course-profile.component.html',
  styleUrls: ['./navbar-course-profile.component.css']
})
export class NavbarCourseProfileComponent implements OnInit {

  userLogged: User;

  constructor(private router: Router, private userService: UserService, private loginService: LoginService) {
    this.userLogged = this.userService.getLoggedUser();
   }

  ngOnInit() {
  }

  onLoggedout() {
    this.userService.logOut();
    this.router.navigate(['/']);
  }

}

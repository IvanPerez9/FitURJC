import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { UserService } from '../user/user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-navbar-course-profile',
  templateUrl: './navbar-course-profile.component.html',
  styleUrls: ['./navbar-course-profile.component.css']
})
export class NavbarCourseProfileComponent implements OnInit {

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
  }

  onLoggedout() {
    this.userService.logOut();
    this.router.navigate(['/']);
  }

}

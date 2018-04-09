import { Component, OnInit } from '@angular/core';
import { NavbarProfile } from "../navbar-profile/navbar-profile.model";
import { Router } from '@angular/router';
import { appRoutes } from '../app.routing';
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

  constructor(private router: Router) { }

  ngOnInit() {
  }

  onSelect(navbar: NavbarProfile): void{
    this.selectedList = navbar;
  }

  navigateTo (linkRouter:string): string{
    for (let rout of appRoutes) {
      if ((linkRouter == rout.path)) {
        return '/' + linkRouter; /*SOLO SE PUEDE IR A COURSES (EXTERNAMENTE)*/
      }
    }
    return '/user/profile/#' + linkRouter;
  }
}

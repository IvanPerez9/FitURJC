import { Component, OnInit } from '@angular/core';
import {Navbar} from "../navbar/navbar.model";
import { Router } from '@angular/router';
import { appRoutes } from '../app.routing';
export const LIST_NAVBAR: Navbar[] = [
  { name: 'Courses' },
  { name: 'Calendar' },
  { name: 'Recommendation' }
];
@Component({
  selector: 'app-navbar-profile',
  templateUrl: './navbar-profile.component.html',
  styleUrls: ['./navbar-profile.component.css']
})
export class NavbarProfileComponent implements OnInit {

  listnavbar = LIST_NAVBAR;

  selectedList: Navbar;
  constructor(private router: Router) { }

  ngOnInit() {
  }

  onSelect(navbar: Navbar):void{
    this.selectedList = navbar;
  }

  navigateTo (linkRouter:String): string{
    for (let rout of appRoutes) {
      if ((linkRouter == rout.path)){
        return '/' + linkRouter /*SOLO SE PUEDE IR A COURSES (EXTERNAMENTE)*/
      }
    }
    return '#profile' +linkRouter;
  }
}

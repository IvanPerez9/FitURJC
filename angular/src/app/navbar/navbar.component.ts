import { Component, OnInit } from '@angular/core';
import { Navbar } from '../navbar';
import { LISTNAVBAR } from '../navbar-home';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  listnavbar = LISTNAVBAR;

  selectedList: Navbar;

  constructor() { }

  ngOnInit() {
  }

  

  onSelect(navbar: Navbar): void {
    this.selectedList = navbar;
  }

}

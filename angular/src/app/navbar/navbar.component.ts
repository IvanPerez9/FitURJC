import { Component, OnInit } from '@angular/core';
import { Navbar } from './navbar.model';
export const LIST_NAVBAR: Navbar[] = [
  { name: 'register' }, //esta puesto a register porque es la unica pagina de momento 'creada'
  { name: 'Professionals' },
  { name: 'Facilities' },
  { name: 'Contact' }
];
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  listnavbar = LIST_NAVBAR;

  selectedList: Navbar;

  constructor() { }

  ngOnInit() {
  }

  onSelect(navbar: Navbar): void {
    this.selectedList = navbar;
  }

}

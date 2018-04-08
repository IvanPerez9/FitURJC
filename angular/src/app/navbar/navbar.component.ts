import { Component, OnInit } from '@angular/core';
import { Navbar } from './navbar.model';
import { Router } from '@angular/router';
import { appRoutes } from '../app.routing';
export const LIST_NAVBAR: Navbar[] = [
  { name: 'profile' },
  { name: 'register' }, //!!!!!!!esta puesto a register porque es la unica pagina de momento 'creada'
  { name: 'professionals' },
  { name: 'facilities' },
  { name: 'contact' }
];
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  listnavbar = LIST_NAVBAR;

  selectedList: Navbar;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  onSelect(navbar: Navbar): void {
    this.selectedList = navbar;
  }

  navigateTo(linkRouter: string): string {
    for (let rout of appRoutes) {
      if ((linkRouter === rout.path)) {
        return '/' + linkRouter;
      }
    }
    return '#' + linkRouter;
  }

}

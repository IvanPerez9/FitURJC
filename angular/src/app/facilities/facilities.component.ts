import { Component, OnInit } from '@angular/core';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { Router } from '@angular/router';
// import { routerTransition } from '../../r';


@Component({
  selector: 'app-facilities',
  templateUrl: './facilities.component.html',
  styleUrls: ['./facilities.component.css'],
  // animations: [routerTransition()]
})
export class FacilitiesComponent implements OnInit {
  imagePaths: string[];


  constructor() {

    this.imagePaths = ['/assets/img/facilities/facilities_1.jpeg',
      '/assets/img/facilities/facilities_2.jpeg', '/assets/img/facilities/facilities_3.jpeg',
      '/assets/img/facilities/facilities_4.jpeg', '/assets/img/facilities/facilities_5.jpeg',
      '/assets/img/facilities/facilities_6.jpeg', '/assets/img/facilities/facilities_7.jpeg',
      '/assets/img/facilities/facilities_8.jpeg', '/assets/img/facilities/facilities_9.jpeg',
      '/assets/img/facilities/facilities_10.jpeg'];
  }

  onScroll () {
    console.log('scrolled!!');
}

  ngOnInit() {
  }

}

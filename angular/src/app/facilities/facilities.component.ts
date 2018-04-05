import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-facilities',
  templateUrl: './facilities.component.html',
  styleUrls: ['./facilities.component.css']
})
export class FacilitiesComponent implements OnInit {
  imagePaths: string[];

  constructor() {
    this.imagePaths = ['/assets/img/facilities/facilities_1.jpeg',
      '/assets/img/facilities/facilities_2.jpeg', '/assets/img/facilities/facilities_3.jpeg',
      '/assets/img/facilities/facilities_4.jpeg', '/assets/img/facilities/facilities_5.jpeg',
      '/assets/img/facilities/facilities_6.jpeg', '/assets/img/facilities/facilities_7.jpeg',
      '/assets/img/facilities/facilities_8.jpeg', '/assets/img/facilities/facilities_9.jpeg',
      '/assets/img/facilities/facilities_10.jpeg']
  }

  ngOnInit() {
  }

}

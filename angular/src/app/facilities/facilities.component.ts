import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-facilities',
  templateUrl: './facilities.component.html',
  styleUrls: ['./facilities.component.css']
})
export class FacilitiesComponent implements OnInit {
imagePaths: string[];

  constructor() {
    this.imagePaths = ['/assets/img/facilities/facilities_1.jpg', '/assets/img/facilities/facilities_2.jpg', '/assets/img/facilities/facilities_3.jpg', '/assets/img/facilities/facilities_4.jpg', '/assets/img/facilities/facilities_5.jpg', '/assets/img/facilities/facilities_6.jpg', '/assets/img/facilities/facilities_7.jpg', '/assets/img/facilities/facilities_8.jpg', '/assets/img/facilities/facilities_9.jpg', '/assets/img/facilities/facilities_10.jpg', '/assets/img/facilities/facilities_11.jpg', '/assets/img/facilities/facilities_12.jpg', '/assets/img/facilities/facilities_13.jpg', '/assets/img/facilities/facilities_14.jpg', '/assets/img/facilities/facilities_15.jpg', '/assets/img/facilities/facilities_16.jpg', '/assets/img/facilities/facilities_17.jpg', '/assets/img/facilities/facilities_18.jpg',
      , '/assets/img/facilities/facilities_19.jpg', '/assets/img/facilities/facilities_20.jpg', '/assets/img/facilities/facilities_21.jpg', '/assets/img/facilities/facilities_22.jpg', '/assets/img/facilities/facilities_23.jpg', '/assets/img/facilities/facilities_24.jpg', '/assets/img/facilities/facilities_25.jpg', '/assets/img/facilities/facilities_26.jpg',
      , '/assets/img/facilities/facilities_27.jpg', '/assets/img/facilities/facilities_28.jpg', '/assets/img/facilities/facilities_29.jpg', '/assets/img/facilities/facilities_30.jpg', '/assets/img/facilities/facilities_31.jpg', '/assets/img/facilities/facilities_32.jpg', '/assets/img/facilities/facilities_33']
  }

  ngOnInit() {
  }

}

import { Component, OnInit } from '@angular/core';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { Router } from '@angular/router';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Http, Headers, RequestOptions } from '@angular/http';

// import { routerTransition } from '../../r';


@Component({
  selector: 'app-facilities',
  templateUrl: './facilities.component.html',
  styleUrls: ['./facilities.component.css'],
  // animations: [routerTransition()]
})
export class FacilitiesComponent implements OnInit {

  imagePaths: string[];

  constructor(private spinnerService: Ng4LoadingSpinnerService, private http: HttpClientBasicAuth) {

    this.imagePaths = ['/assets/img/facilities/facilities_1.jpeg',
      '/assets/img/facilities/facilities_2.jpeg', '/assets/img/facilities/facilities_3.jpeg',
      '/assets/img/facilities/facilities_4.jpeg', '/assets/img/facilities/facilities_5.jpeg',
      '/assets/img/facilities/facilities_6.jpeg', '/assets/img/facilities/facilities_7.jpeg',
      '/assets/img/facilities/facilities_8.jpeg', '/assets/img/facilities/facilities_9.jpeg',
      '/assets/img/facilities/facilities_10.jpeg'];
  }

  onScroll() {
    console.log('scrolled!!');
  }

  ngOnInit() {

  }

  moreCourses() {
    this.spinnerService.show();

    setTimeout(function() {
      this.spinnerService.hide();//AQUI HAY QUE HACER LA LLAMADA A LA API
    }.bind(this.imagePaths),4000);
  }
}
import { Component, OnInit } from '@angular/core';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { Router } from '@angular/router';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Http, Headers, RequestOptions } from '@angular/http';
import { FacilitiesService } from "./facilities.service";

// import { routerTransition } from '../../r';


@Component({
  selector: 'app-facilities',
  templateUrl: './facilities.component.html',
  styleUrls: ['./facilities.component.css'],
  // animations: [routerTransition()]
})
export class FacilitiesComponent implements OnInit {


  // public facilitiesPage: number;
  // public facilitiesPageActual: number;
  // public moreEventsButtonText: string;
  imagePaths: string[];
  facilities;
  sum: number;
  finished: boolean;

  constructor(private spinnerService: Ng4LoadingSpinnerService, private http: HttpClientBasicAuth, private facilitiesService: FacilitiesService, private router: Router) {

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
    this.initFacilities();
  }

  initFacilities() {
    this.sum = 0;
    this.spinnerService.show();
    this.facilitiesService.getFacilities(this.sum).subscribe(
      result => {
        this.imagePaths = result;
        this.spinnerService.hide();
      },
      error => {
        console.log(error);
        this.spinnerService.hide();
      });
  }

  moreCourses() {
    if (!this.finished) {
      this.spinnerService.show();
      this.sum += 1;
      this.facilitiesService.getFacilities(this.sum).subscribe(
        result => {
          if (result.length < 10) {
            this.finished = true;
          }
          result.forEach(element => {
            this.imagePaths.push(element);
          });
          this.spinnerService.hide();
        },
        error => {
          this.spinnerService.hide();
        });
    }
  }

}

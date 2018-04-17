import { Component, OnInit } from '@angular/core';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { Router } from '@angular/router';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Http, Headers, RequestOptions } from '@angular/http';
import { FacilitiesService } from "./facilities.service";
import { Facilities } from './facilities.model';
import * as globals from '../globals';


@Component({
  selector: 'app-facilities',
  templateUrl: './facilities.component.html',
  styleUrls: ['./facilities.component.css'],
})

export class FacilitiesComponent implements OnInit {

  facilities: Facilities[] = [];
  sum: number;
  finished: boolean;

  constructor(private spinnerService: Ng4LoadingSpinnerService, private http: HttpClientBasicAuth, private facilitiesService: FacilitiesService, private router: Router) {
  }

  ngOnInit() {
    this.initFacilities();
  }

  onScroll() {
    console.log('scrolled!!');
  }

  initFacilities() {
    this.sum = 0;
    this.spinnerService.show();
    this.facilitiesService.getFacilities(this.sum).subscribe(
      result => {
        console.log(result)
        this.facilities = result;
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
            this.facilities.push(element);
          });
          this.spinnerService.hide();
        },
        error => {
          this.spinnerService.hide();
        });
    }
  }

  getUriImage(uriImage: string): string {
    return globals.BASEURL_IMAGE + uriImage;
  }

}

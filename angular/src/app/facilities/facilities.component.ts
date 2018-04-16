import { Component, OnInit } from '@angular/core';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { Router } from '@angular/router';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Http, Headers, RequestOptions } from '@angular/http';
import {FacilitiesService} from "./facilities.service";

// import { routerTransition } from '../../r';


@Component({
  selector: 'app-facilities',
  templateUrl: './facilities.component.html',
  styleUrls: ['./facilities.component.css'],
  // animations: [routerTransition()]
})
export class FacilitiesComponent implements OnInit {


  // necessary variables
  public facilitiesPage: number;
  public facilitiesPageActual: number;
  public moreEventsButtonText: string;
  public imagePaths: string[];
  public facilities;

  constructor(private spinnerService: Ng4LoadingSpinnerService, private http: HttpClientBasicAuth, private service: FacilitiesService, private router: Router) {

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
    this.facilitiesPage = 0;
    this.moreEventsButtonText="Show more";
    this.service.getFacilities(this.facilitiesPage).subscribe(
      response => {
        this.facilitiesPage++;
        this.facilities = response.content;
        this.facilitiesPageActual= response.totalPages;
      },
      error=>{
        console.log(error);
      }

    )


  }

  moreCourses() {
    this.spinnerService.show();
    setTimeout(function() {
      this.spinnerService.hide();//AQUI HAY QUE HACER LA LLAMADA A LA API
    }.bind(this.imagePaths),4000);
  }
}

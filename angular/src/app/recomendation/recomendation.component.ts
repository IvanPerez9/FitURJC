import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { Course } from '../course-profile/course-profile.model';
import {HttpClientBasicAuth} from "../HttpClient/httpClient";
import * as globals from "../globals";
import {USER_BASEURL} from "../globals";

@Component({
  selector: 'app-recomendation',
  templateUrl: './recomendation.component.html',
  styleUrls: ['./recomendation.component.css']
})
export class RecomendationComponent implements OnInit {

  courses: Course[] = [];


  constructor(private router: Router, private loginService: LoginService, private httpClient: HttpClientBasicAuth) {
    }

  ngOnInit() {
    this.getRecommendedCourses();
  }

  private getRecommendedCourses(){
    let url = globals.SCHEDULE_BASEURL;
    this.httpClient.get("https://fiturjc.lavandadelpatio.es/api/user/recommendedCourses").subscribe(
      value => {
        this.courses = value as Course[];
        console.log("Recomendaciones");
        console.log(value);
      },
          error1 => console.log(error1)
    );
  }
}

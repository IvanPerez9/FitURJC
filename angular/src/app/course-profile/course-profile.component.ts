import { Component, OnInit } from '@angular/core';
import { forEach } from '@angular/router/src/utils/collection';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../login/login.service';
import { Schedule } from '../schedule/schedule.model';
import { ScheduleService } from '../schedule/schedule.service';
import { error } from 'util';


@Component({
  selector: 'app-course-profile',
  templateUrl: './course-profile.component.html',
  styleUrls: ['./course-profile.component.css']
})
export class CourseProfileComponent implements OnInit {

  schedules: string[];
  imagePaths: string[];

  constructor(private router: Router, private loginService: LoginService, private scheduleService: ScheduleService) {
    // this.schedules = ['01:00-02:00', '02:00-03:00', '03:00-04:00', '04:00-05:00', '05:00-06:00',
    // '06:00-07:00', '07:00-08:00', '08:00-09:00', '09:00-10:00', '10:00-11:00', '11:00-12:00', '12:00-13:00']
  }

  ngOnInit() {
     this.scheduleService.getSchedules().subscribe(
      schedule => {
        this.schedules = schedule;
      },
      error => {
        console.log('ERROR!!! LISTA DE SCHEDULES');
      }
    )
  }

}


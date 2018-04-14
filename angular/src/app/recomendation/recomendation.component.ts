import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { ScheduleService } from '../schedule/schedule.service';
import { CourseProfileService } from '../course-profile/course-profile.service';
import { Course } from '../course-profile/course-profile.model';
import { Schedule } from '../schedule/schedule.model';

@Component({
  selector: 'app-recomendation',
  templateUrl: './recomendation.component.html',
  styleUrls: ['./recomendation.component.css']
})
export class RecomendationComponent implements OnInit {

  courses: Array<Course>;
  schedules: Schedule[];

  constructor(private router: Router, private loginService: LoginService, private courseProfileService: CourseProfileService, 
    private scheduleService: ScheduleService) {

    }

  ngOnInit() {

  }

  initCourses() {
    this.courseProfileService.getCourses().subscribe(
      course => {
        this.courses = course;
      },
      error => {
        console.log(error);
      }
    )
  }

  initSchedules() {
    this.courses.forEach(course => course.schedules.forEach)
    this.scheduleService.getSchedules().subscribe(
      schedule => {
        this.schedules = schedule;
      },
      error => {
        console.log(error);
      }
    )
  }

}

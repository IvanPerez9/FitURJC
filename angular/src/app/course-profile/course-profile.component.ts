import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../login/login.service';
import { Course } from '../course-profile/course-profile.model';
import { CourseProfileService } from '../course-profile/course-profile.service';
import { Schedule } from '../schedule/schedule.model';
import { ScheduleService } from '../schedule/schedule.service';
import { error } from 'util';


@Component({
  selector: 'app-course-profile',
  templateUrl: './course-profile.component.html',
  styleUrls: ['./course-profile.component.css']
})
export class CourseProfileComponent implements OnInit {

  courses: Array<Course>;
  schedules: Schedule[];

  constructor(private router: Router, private loginService: LoginService, private courseProfileService: CourseProfileService, 
              private scheduleService: ScheduleService) {
  }

  ngOnInit() {
    this.initCourses();
    // this.initSchedules();
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


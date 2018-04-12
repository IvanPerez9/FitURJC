import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../../login/login.service';
import { Course } from '../../course-profile/course-profile.model';
import { CourseProfileService } from '../../course-profile/course-profile.service';
import { Schedule } from '../../schedule/schedule.model';
import { ScheduleService } from '../../schedule/schedule.service';

@Component({
  selector: 'app-admin-control-courses',
  templateUrl: './admin-control-courses.component.html',
  styleUrls: ['./admin-control-courses.component.css']
})
export class AdminControlCoursesComponent implements OnInit {

  courses: Course[];
  schedules: Schedule[];

  constructor(private router:Router, private courseProfileService: CourseProfileService, 
              private loginService: LoginService, private scheduleService: ScheduleService){}

   ngOnInit() {
    this.initCourses();
    this.initSchedules();
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

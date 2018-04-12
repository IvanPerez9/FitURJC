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

  courses: Array<Course>;
  schedules: Schedule[];

  constructor(private router: Router, private courseProfileService: CourseProfileService,
    private loginService: LoginService, private scheduleService: ScheduleService) { }

  ngOnInit() {
    this.initCourses();
    // this.initSchedules();
  }

  initCourses() {
    this.courseProfileService.getCourses().subscribe(
      resultCourses => {
        console.log(resultCourses)
        this.courses = resultCourses;
      },
      error => {
        console.log(error);
      }
    )
  }

  goToAddCourse(){
    console.log("naveggnado")
    this.router.navigate(['/admin/controlCourses/addCourse']);
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

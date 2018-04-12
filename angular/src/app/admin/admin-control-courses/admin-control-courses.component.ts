import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../../login/login.service';
import { Course } from '../../course-profile/course-profile.model';
import { CourseProfileService } from '../../course-profile/course-profile.service';

@Component({
  selector: 'app-admin-control-courses',
  templateUrl: './admin-control-courses.component.html',
  styleUrls: ['./admin-control-courses.component.css']
})
export class AdminControlCoursesComponent implements OnInit {

  courses: Course[];

  constructor(private router:Router, private courseProfileService: CourseProfileService, private loginService: LoginService){}

   ngOnInit() {
    this.courseProfileService.getCourses().subscribe(
      course => {
        this.courses = course;
      },
      error => {
        console.log(error);
      }
    )
  }
}

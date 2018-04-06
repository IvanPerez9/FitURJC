import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../../login/login.service';
import { Course } from '../../course/course.model';
import { CourseService } from '../../course/course.service';

@Component({
  selector: 'app-admin-control-courses',
  templateUrl: './admin-control-courses.component.html',
  styleUrls: ['./admin-control-courses.component.css']
})
export class AdminControlCoursesComponent implements OnInit {

  courses: Course[];

  constructor(private router:Router, private service: CourseService, private sessionService: LoginService){}

   ngOnInit() {
    this.service.getCourses().subscribe(
      course => {
        this.courses = course;
      },
      error => {
        console.log(error);
      }
    )
  }
}

import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Course } from '../course-profile/course-profile.model';
import { CourseProfileService } from '../course-profile/course-profile.service';


@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})

export class CourseComponent implements OnInit {

  courses: Course[];

  constructor(private router: Router, private courseProfileService: CourseProfileService) {
  }


  ngOnInit() {
    
  }

  initCourses() {
    this.courseProfileService.getCourses().subscribe(
      courses => {
        this.courses = courses;
      },
      error => {
        console.log('ERROR!!! COURSES');
      }
    )
  }
}
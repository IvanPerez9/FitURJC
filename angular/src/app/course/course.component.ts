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
  imagePaths: string[];

  constructor(private router: Router, private courseProfileService: CourseProfileService) {

    this.imagePaths = ['/assets/img/courses/Aerobic.jpg', '/assets/img/courses/Body Combat.jpg', '/assets/img/courses/Boxing.jpg',
      '/assets/img/courses/Cardio.jpg', '/assets/img/courses/CrossFit.jpg', '/assets/img/courses/Dumbbells.jpg']
  }
  

  ngOnInit() {
    this.courseProfileService.getCourses().subscribe(
      courses => {
        this.courses = courses.content;
      },
      error => {
        console.log('ERROR!!! COURSES');
      }
    )
  }

}
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  imagePaths: string[];

  constructor() {
    this.imagePaths = ['/assets/img/courses/Aerobic.jpg', '/assets/img/courses/Body Combat.jpg', '/assets/img/courses/Boxing.jpg',
      '/assets/img/courses/Cardio.jpg', '/assets/img/courses/CrossFit.jpg', '/assets/img/courses/Dumbbells.jpg']
  }

  ngOnInit() {
  }

}

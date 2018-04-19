import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../../login/login.service';
import { Course, Category } from '../../course-profile/course-profile.model';
import { CourseProfileService } from '../../course-profile/course-profile.service';
import { Schedule } from '../../schedule/schedule.model';
import { ScheduleService } from '../../schedule/schedule.service';
import { AdminControlCoursesService } from '../../admin/admin-control-courses/admin-control-courses.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';


@Component({
  selector: 'app-add-courses',
  templateUrl: './add-courses.component.html',
  styleUrls: ['./add-courses.component.css']
})
export class AddCoursesComponent implements OnInit {

  courseCategory: any = Object.keys(Category);
  courses: Array<Course>;
  ifSaveCourse: FormGroup;
  addNewCourse: SaveCourses;

  constructor(private router: Router, private courseProfileService: CourseProfileService, private controlCourses: AdminControlCoursesService,
    private loginService: LoginService) { }


  ngOnInit() {
    this.initCourses();
    this.ifSaveCourse = new FormGroup({
      //   id: new FormControl('', Validators.required),
      name: new FormControl('', Validators.required),
      category: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      schedule: new FormControl([], Validators.required),
      //   src: new FormControl('', Validators.required),
    });
  }

  initCourses() {
    this.courseProfileService.getCourses().subscribe(
      resultCourses => {
        console.log(resultCourses);
        this.courses = resultCourses;
      },
      error => {
        console.log(error);
      }
    );
  }

  onSubmit(form: FormGroup) {
    const valuesForm: any = form.value;
    this.addNewCourse = valuesForm;
    console.log(this.addNewCourse);
    this.controlCourses.createCourse(this.addNewCourse).subscribe(
      result => {
        this.router.navigate(['/admin/controlCourses']);
      },
      error => {
        console.log(error);
        console.log(error.code);
      }
    );
    return;
  }

}

export interface SaveCourses {
  name: string;
  //  id: number;
  category: Category;
  description: string;
  schedule: string;
  // src: string;
}

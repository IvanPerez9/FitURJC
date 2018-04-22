import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../login/login.service';
import {Course} from './course-profile.model';
import {CourseProfileService} from './course-profile.service';
import {ScheduleService} from '../schedule/schedule.service';
import {User} from "../user/user.model";
import {UserService} from '../user/user.service';
import {Schedule} from "../schedule/schedule.model";
import {Ng4LoadingSpinnerService} from 'ng4-loading-spinner';
import * as globals from '../globals';


@Component({
  selector: 'app-course-profile',
  templateUrl: './course-profile.component.html',
  styleUrls: ['./course-profile.component.css']
})

export class CourseProfileComponent implements OnInit {

  courses: Array<Course>;
  userLogged: User;
  signup: boolean;
  quit: boolean;
  sum: number;
  finished: boolean;

  constructor(private router: Router, private loginService: LoginService, private courseProfileService: CourseProfileService, private scheduleService: ScheduleService, private userService: UserService, private spinnerService: Ng4LoadingSpinnerService) {
    this.userLogged = this.userService.getLoggedUser();
  }

  ngOnInit() {
    this.initCourses();
  }

  initCourses() {
    this.sum = 0;
    this.spinnerService.show();
    this.courseProfileService.getCourse(this.sum).subscribe(
      course => {
        this.courses = course;
        this.spinnerService.hide();
        console.log(course);
      },
      error => {
        console.log(error);
        this.spinnerService.hide();
      });
  }

  moreCourse() {
    if (!this.finished) {
      this.spinnerService.show();
      this.sum += 1;
      this.courseProfileService.getCourse(this.sum).subscribe(
        result => {
          if (result.length < 6) {
            this.finished = true;
          }
          result.forEach(element => {
            this.courses.push(element);
          });
          this.spinnerService.hide();
        },
        error => {
          this.spinnerService.hide();
        });
    }
  }

  getUriImage(uriImage: string): string {
    return globals.COURSE_BASEURL + uriImage;
  }


  isUserEnrolled(schedule: Schedule): boolean {
    let user = schedule.listUsers.find(user => user.id === this.userLogged.id);
    return !!user;
  }

  unEnroll(idSchedule: number) {
    this.scheduleService.unsubscribeSchedule(idSchedule).subscribe(
      respuesta => {
        this.quit = true;
        setTimeout(() => {
          this.router.navigate(['/user/profile']);
        }, 2000);
        console.log("OK");
      },
      error => console.log("SOMETHING BAD"),
      () => console.log("PFF")
    );

  }

  enroll(idSchedule: number) {
    this.scheduleService.joinSchedule(idSchedule).subscribe(
      respuesta => {
        this.signup = true;
        setTimeout(() => {
          this.router.navigate(['/user/profile']);
        }, 2000);
        console.log("GOOD JOIN");
      },
      error => console.log("NOT JOIN")
    );
  }
}


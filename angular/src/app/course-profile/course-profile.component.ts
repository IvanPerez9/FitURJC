import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { Course } from './course-profile.model';
import { CourseProfileService } from './course-profile.service';
import { ScheduleService } from '../schedule/schedule.service';
import { User } from "../user/user.model";
import { UserService } from '../user/user.service';
import { Schedule } from "../schedule/schedule.model";



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

  constructor(private router: Router, private loginService: LoginService, private courseProfileService: CourseProfileService,
    private scheduleService: ScheduleService, private userService: UserService) {
    this.userLogged = this.userService.getLoggedUser();
  }

  ngOnInit() {
    this.initCourses();
    // this.initSchedules();
  }

  initCourses() {
    this.courseProfileService.getCourses().subscribe(
      course => {
        this.courses = course;
        console.log(course);
      },
      error => {
        console.log(error);
      }
    )
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
        console.log("Todo ha ido bien");
      },
      error => console.log("Algo ha ido mal"),
      () => console.log("me da igual lo que haya pasado, yo siempre me voy a ejecutar")
    );

  }
  enroll(idSchedule: number) {
    this.scheduleService.joinSchedule(idSchedule).subscribe(
      respuesta => {
        this.signup = true;
        setTimeout(() => {
          this.router.navigate(['/user/profile']);
        }, 2000);
        console.log("DE PUTA MARE");
      },
      error => console.log("AL CARRER")
    );
  }
}


import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Schedule } from './schedule.model';
import { ScheduleService } from './schedule.service';
import { LoginService } from '../login/login.service';
import { Course } from '../course-profile/course-profile.model';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';
import { CourseProfileService } from '../course-profile/course-profile.service';
import { forEach } from '@angular/router/src/utils/collection';


@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  schedules: Schedule[] = [];
  idSchedule: number;
  schedule: Schedule;
  users: User[] = [];
  user: User;
  course: Course;
  courses: Array<Course>;
  signup: boolean;
  userLogged: User;
  listScheduleWithUser: Schedule[] = [];
  canEvaluate: boolean;

  constructor(private router: Router, private loginService: LoginService, private scheduleService: ScheduleService, private userService: UserService, private courseProfileService: CourseProfileService) {

    this.userLogged = this.userService.getLoggedUser();
  }

  ngOnInit() {
    this.initCourses();
  }

  initCourses() {
    this.courseProfileService.getCourses().subscribe(
      course => {
        this.courses = course;
        this.fillShedules(this.courses);
      },
      error => {
        console.log(error);
      }
    )
  }

  fillShedules(courses: Course[]): void {
    for (let course of courses) {
      this.schedules.push.apply(this.schedules, course.schedules)
    }
    console.log(this.schedules)
    this.fillUserLoggedSchedules();
  }

  fillUserLoggedSchedules() {
    for (let schedule of this.schedules) {
      console.log("Passsnado por aqui")
      for (let user of schedule.listUsers) {
        if (user.email.indexOf(this.userLogged.email) > -1) {
          console.log("Añadiento usuario")
          this.listScheduleWithUser.push(schedule);
        }
      }
    }
    this.canEvaluate = true;
  }

  initSchedules() {
    this.scheduleService.getSchedules().subscribe(
      schedule => {
        this.schedules = schedule;
      },
      error => {
        console.log(error);
      }
    );
  }

  initUsers() {
    this.userService.getUsers().subscribe(
      user => {
        console.log("Pidiendo usuarios y su devolucion")
        this.users = user;
      },
      error => {
        console.log(error);
      }
    )
  }

  follow() {
    this.scheduleService.joinSchedule(this.idSchedule).subscribe(
      response => {
        // this.listUsers = this.listUsers.push(this.userService.getLoggedUser());
        this.loginService.getUser();
        this.scheduleService.getScheduleById(this.idSchedule);
        console.log('Success, Join' + this.loginService.getUser() + 'Schedule:' + this.scheduleService.getScheduleById(this.idSchedule));
      },
      error => {
        console.log(error.code);
        console.log('Fail to Join' + this.loginService.getUser() + 'Schedule:' + this.scheduleService.getScheduleById(this.idSchedule));
      });
  }
}

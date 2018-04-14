import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Schedule } from './schedule.model';
import { ScheduleService } from './schedule.service';
import { LoginService } from '../login/login.service';
import { Course } from '../course-profile/course-profile.model';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';


@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  schedules: Schedule[];
  idSchedule: number;
  schedule: Schedule;
  listUsers: User[];
  course: Course;
  signup: boolean;

  constructor
  (private router: Router, private loginService: LoginService, private scheduleService: ScheduleService, private userService: UserService) {
  }

  ngOnInit() {
    this.initSchedules();
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

  follow() {
    this.scheduleService.joinSchedule(this.idSchedule).subscribe(
      response => {
       // this.listUsers = this.listUsers.push(this.userService.getLoggedUser()); FALTA QUE SEA METER USUARIOS ENTEROS
        this.loginService.getUser();
        this.scheduleService.getScheduleById(this.idSchedule);
        console.log ('Success, Join' + this.loginService.getUser() + 'Schedule:' + this.scheduleService.getScheduleById(this.idSchedule));
      },
      error => {
        console.log(error.code);
        console.log ('Fail to Join' + this.loginService.getUser() + 'Schedule:' + this.scheduleService.getScheduleById(this.idSchedule));
    });
  }

  /*
     checkIfFollow(id: number) {
      this.schedule = this.scheduleService.getScheduleById(id);
         if (this.loginService.isLogged) {
           let aux: boolean = (this.schedul(
             user1 => user1.id === this.userService.getLoggedUser() !== undefined)); // Done by ID ??
           return aux;
         }
     }
     */


}

import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Schedule } from './schedule.model';
import { ScheduleService } from './schedule.service';
import { LoginService } from '../login/login.service';


@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  schedules: Schedule[];

  constructor(private router: Router, private loginService: LoginService, private scheduleService: ScheduleService) {
  
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
    )
  }

}

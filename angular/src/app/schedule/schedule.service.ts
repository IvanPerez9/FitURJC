import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
import { Schedule } from './schedule.model';
import { User } from '../user/user.model';
import { UserRegister } from '../register/register.component';
import { LoginService } from '../login/login.service';
// tslint:disable-next-line:import-blacklist
import 'rxjs/Rx';
import * as globals from '../globals';
import { map } from 'rxjs/operators';
import { Course } from '../course-profile/course-profile.model';

@Injectable()
export class ScheduleService {

    schedule: Schedule;
    user: User;

    constructor(private http: HttpClientBasicAuth, private loginService: LoginService)  {

    }

    getSchedule(): Observable<any> {
        let url = globals.SCHEDULE_BASEURL;
        return this.http.get(url);
    }

    getScheduleById(sheduleId: number): Observable<any> {
        let url = globals.SCHEDULE_BASEURL;
        return this.http.get(url + sheduleId);
    }

    deleteSchedule(schedule: Schedule) {
        let url = globals.SCHEDULE_BASEURL;
        return this.http.delete(url);
    }

    joinSchedule(scheduleId: number, schedule: Schedule) {
        let url = globals.SCHEDULE_BASEURL;
        return this.http.put(url + scheduleId, schedule);
    }

    unsubscribeSchedule(scheduleId: number, schedule: Schedule) {
        let url = globals.SCHEDULE_BASEURL;
        return this.http.put(url + scheduleId, schedule);
    }

    checkIfFollow() {
        if (this.loginService.isLogged) {
          let aux: boolean = (this.schedule.listUsers.find(
            user1 => user1.userId === this.user.userId) !== undefined); // Done by ID ??
          return aux;
        }
    }
}

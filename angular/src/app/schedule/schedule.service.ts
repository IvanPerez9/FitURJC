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
import { Course, Category } from '../course-profile/course-profile.model';
import { CourseProfileService } from '../course-profile/course-profile.service'


@Injectable()
export class ScheduleService {

    

    constructor(private http: HttpClientBasicAuth, private loginService: LoginService)  {
    }

    getSchedules(): Observable<any> {
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


    //IVAN
    // checkIfFollow() {
    //     if (this.loginService.isLogged) {
    //       let aux: boolean = (this.schedule.listUsers.find(
    //         user1 => user1.id === this.user.id) !== undefined); // Done by ID ??
    //       return aux;
    //     }
    // }
}

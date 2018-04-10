import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
import { Schedule } from './schedule.model';
import { User } from '../user/user.model';
import { UserRegister } from '../register/register.component';
import 'rxjs/Rx';
import * as globals from '../globals';
import { map } from 'rxjs/operators';

@Injectable()
export class ScheduleService {

    constructor(private http: HttpClientBasicAuth) {

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







}

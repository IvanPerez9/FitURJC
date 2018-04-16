import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
import { Schedule } from './schedule.model';
import { LoginService } from '../login/login.service';
import 'rxjs/Rx';
import * as globals from '../globals';


@Injectable()
export class ScheduleService {


    constructor(private http: HttpClientBasicAuth, private loginService: LoginService)  {
    }

    getSchedules(): Observable<Schedule[]> {
      return this.http.get(globals.SCHEDULE_BASEURL) as Observable<Schedule[]>;
    }

    getScheduleById(sheduleId: number): Observable<any> {
        let url = globals.SCHEDULE_BASEURL;
        return this.http.get(url + sheduleId);
    }

    deleteSchedule(schedule: Schedule) {
        let url = globals.SCHEDULE_BASEURL;
        return this.http.delete(url);
    }

    joinSchedule(scheduleId: number) {
        let url = globals.SCHEDULE_BASEURL;
        return this.http.put(url + scheduleId + '/join', this.getScheduleById(scheduleId));
    }

    unsubscribeSchedule(scheduleId: number) {
        let url = globals.SCHEDULE_BASEURL;
        return this.http.put(url + scheduleId + '/unsubscribe', this.getScheduleById(scheduleId));
    }

}

import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
import { Schedule } from './schedule.model';
import { User } from '../user/user.model';
import { UserRegister} from '../register/register.component';
import 'rxjs/Rx';
import * as globals from '../globals';
import { map } from 'rxjs/operators';

@Injectable()
export class ScheduleService {

    url: string;
    schedule: Schedule;

    constructor(private http: HttpClientBasicAuth) {
        this.url = globals.USER_BASEURL; //¿THISSSSSSSSSS?
    }

    getSchedule(): Observable<any> {
        return this.http.get(this.url);
    }

    getScheduleById(sheduleId: number): Observable<any> {
        return this.http.get(this.url + sheduleId);
    } 





   

}

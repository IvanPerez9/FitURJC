import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
// tslint:disable-next-line:import-blacklist
import 'rxjs/Rx';
import * as globals from '../../globals';
import { Course, Category } from '../../course-profile/course-profile.model';
import { Schedule } from '../../schedule/schedule.model';
import { User } from '../../user/user.model';

@Injectable()
export class AdminControlUsersService {

    url: string;

    constructor(private http: HttpClientBasicAuth) {
    }

    getUsers(): Observable<any> {
        let url = globals.ADMIN_USERURL;
        return this.http.get(url);
    }

    getUsersId(courseId: number | string) {
        let url = globals.ADMIN_COURSEURL;
        return this.http.get(url + courseId);
    }

}
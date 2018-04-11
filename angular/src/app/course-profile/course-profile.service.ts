import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
// tslint:disable-next-line:import-blacklist
import 'rxjs/Rx';
import * as globals from '../globals';
import { Course, Category } from './course-profile.model';
import { Schedule } from '../schedule/schedule.model';
import { LoginService } from '../login/login.service';
import { User } from '../user/user.model';

@Injectable()
export class CourseProfileService {


    constructor(private http: HttpClientBasicAuth, private loginService: LoginService) {
    }

    getCourses(): Observable<any> {
        let url = globals.COURSE_BASEURL;
        return this.http.get(url);
    }

    getCourseId(courseId: number | string) {
        let url = globals.COURSE_BASEURL;
        return this.http.get(url + courseId);
    }

    editCourse (courseId: number | string , course: Course) {
        let url = globals.COURSE_BASEURL;
        return this.http.put(url + courseId , course);
    }

    // getListSchedules (schedule: Schedule) {
    //     return this.http.get(this.url + schedule);
    // }

    private errors (error: any) {
        console.error(error);
        return Observable.throw('Error (' + error.status + '): ' + error.text() );
    }


}

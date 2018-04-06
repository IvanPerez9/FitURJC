import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
// tslint:disable-next-line:import-blacklist
import 'rxjs/Rx';
import * as globals from '../globals';
import { Course } from './course.model';

@Injectable()
export class CourseService {

    url: string;

    constructor(private http: HttpClientBasicAuth) {
        this.url = globals.USER_BASEURL;
    }

    getCourses(): Observable<any> {
        return this.http.get(this.url);
    }

}

import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
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

    getCourse(page: number): Observable<any> {
        return this.http.get(globals.COURSE_BASEURL + '?page=' + String(page) + '&size=10');
      }

    getCourses(): Observable<any> {
        let url = globals.COURSE_BASEURL;
        return this.http.get(url);
    }

    getCourseId(courseId: number | string):Observable<any> {
        let url = globals.COURSE_BASEURL;
        return this.http.get(url + courseId);
    }

    editCourse (courseId: number | string , course: Course) {
        let url = globals.COURSE_BASEURL;
        return this.http.put(url + courseId , course);
    }

    private errors (error: any) {
        console.error(error);
        return Observable.throw('Error (' + error.status + '): ' + error.text() );
    }

    deleteCourse(id: number | string): Observable<any> {
        let url = globals.ADMIN_COURSEURL;
        return this.http.delete(url + 'delete/' + id);
    }


}

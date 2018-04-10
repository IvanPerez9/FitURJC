import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
// tslint:disable-next-line:import-blacklist
import 'rxjs/Rx';
import * as globals from '../../globals';
import { Course, Category } from '../../course/course.model';
import { Schedule } from '../../schedule/schedule.model';

@Injectable()
export class AdminControlCoursesService {

    url: string;

    constructor(private http: HttpClientBasicAuth) {
        this.url = globals.BASEURL;
    }

    getCourses(): Observable<any> {
        return this.http.get(this.url);
    }

    getCourseId(courseId: number | string) {
        let url = globals.ADMIN_COURSEURL;
        return this.http.get(this.url + courseId);
    }

    updateCourse(courseId: number | string, course: Course) {
        let url = globals.ADMIN_COURSEURL;
        return this.http.patch(this.url + 'edit/' + courseId, course);
    }

    createCourse(course: Course) {
        let url = globals.ADMIN_COURSEURL;
        return this.http.post(this.url + 'add', course);
    }

    deleteCourse(courseId: number | string) {
        let url = globals.ADMIN_COURSEURL;
        return this.http.delete(this.url + 'delete/' + courseId);
    }
}
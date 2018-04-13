import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
// tslint:disable-next-line:import-blacklist
import 'rxjs/Rx';
import * as globals from '../../globals';
import { Course, Category } from '../../course-profile/course-profile.model';
import { Schedule } from '../../schedule/schedule.model';

@Injectable()
export class AdminControlCoursesService {

    url: string;

    constructor(private http: HttpClientBasicAuth) {
    
    }

    getCourses(): Observable<any> {
        let url = globals.ADMIN_COURSEURL;
        return this.http.get(url);
    }

    getCourseId(courseId: number | string) {
        let url = globals.ADMIN_COURSEURL;
        return this.http.get(url + courseId);
    }

    updateCourse(courseId: number | string, course: Course) {
        let url = globals.ADMIN_COURSEURL;
        return this.http.patch(url + 'edit/' + courseId, course);
    }

    createCourse(course: Course) {
        let url = globals.ADMIN_COURSEURL;
        return this.http.post(url + 'add', course);
    }

    deleteCourse(id: number | string) {
        let url = globals.ADMIN_COURSEURL;
        return this.http.delete(url + 'delete/' + id);
    }
}

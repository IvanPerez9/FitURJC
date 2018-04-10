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
        this.url = globals.USER_BASEURL; // This ???????
    }

    getCourses(): Observable<any> {
        return this.http.get(this.url);
    }

    getCourse(courseId: number | string) {
        return this.http.get(this.url + courseId);
    }

    createCourse(course: Course) {
        return this.http.post(this.url , course);
    }

    deleteCourse(courseId: number | string) {
        return this.http.delete(this.url + courseId);
    }

    editCourse (courseId: number | string , course: Course) {
        return this.http.put(this.url + courseId , course);
    }

    subscribeToCourse(courseName: string) {
        return this.http.put(this.url + courseName + '/members', null); // añadir el userLoggedd ???
    }

    setCoursePhoto (courseId: number, formData: FormData ) {
        return this.http.put(this.url + courseId , formData);
    }

    private errors (error: any) {
        console.error(error);
        return Observable.throw('Error (' + error.status + '): ' + error.text() );
    }


}

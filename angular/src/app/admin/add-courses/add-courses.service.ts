import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
// tslint:disable-next-line:import-blacklist
import 'rxjs/Rx';
import * as globals from '../../globals';
import { Course, Category } from '../../course-profile/course-profile.model';
import { Schedule } from '../../schedule/schedule.model';

@Injectable()
export class AddCoursesService {

    url: string;

    constructor(private http: HttpClientBasicAuth) {
    
    }

   

}
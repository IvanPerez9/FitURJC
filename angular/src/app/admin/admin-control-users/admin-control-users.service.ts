import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import * as globals from '../../globals';
import { Course, Category } from '../../course-profile/course-profile.model';
import { Schedule } from '../../schedule/schedule.model';
import { User } from '../../user/user.model';
import { AdminEditUser } from './admin-control-users.component';

@Injectable()
export class AdminControlUsersService {

    url: string;

    constructor(private http: HttpClientBasicAuth) {
    }

    getUsers(): Observable<any> {
        let url = globals.ADMIN_USERURL;
        return this.http.get(url);
    }

    getUsersId(id: number | string): Observable<any> {
        let url = globals.ADMIN_USERURL;
        return this.http.get(url + id);
    }

    deleteUser(id: number | string): Observable<any> {
        let url = globals.ADMIN_USERURL;
        return this.http.delete(url + 'user/delete/' + id);
    }

    editUser(id: number, user: AdminEditUser): Observable<any> {
        let url = globals.ADMIN_USERURL;
        return this.http.patch(url + 'user/edit/' + id, user);
    }


}

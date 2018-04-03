import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
// tslint:disable-next-line:import-blacklist
import 'rxjs/Rx';
import * as globals from '../globals';

@Injectable()
export class UserService {

    url: string;

    constructor(private http: HttpClientBasicAuth) {
        this.url = globals.USER_BASEURL;
    }

    getUsers(): Observable<any> {
        return this.http.get(this.url);
    }

    getUser(nick: String): Observable<any> {
        return this.http.get(this.url + nick);
    }

}

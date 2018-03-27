import { Injectable } from '@angular/core';
import { HttpClient } from '../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import * as globals from '../globals';

@Injectable()
export class UserService {

    url: string;

    constructor(private http: HttpClient) {
        this.url = globals.USER_BASEURL;
    }
   


    getUsers() {

        return this.http.get(this.url)
            .map(response => response.json())
            .catch(error => this.handleError(error));

    }

    getUser(nick: String) {
        return this.http.get(this.url + nick)
            .map(response => response.json())
            .catch(error => this.handleError(error));
    }



    private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error.text());
    }
}

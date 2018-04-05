import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
// tslint:disable-next-line:import-blacklist
import 'rxjs/Rx';
import * as globals from '../globals';
import { User } from './user.model';

@Injectable()
export class UserService {

    url: string;

    constructor(private http: HttpClientBasicAuth) {
        this.url = globals.USER_BASEURL;
    }

    getUsers(): Observable<any> {
        return this.http.get(this.url);
    }

    getUser(email: String ): Observable<any> {
        return this.http.get(this.url + email);
    }

    setUserLogged(user: User) {
        this.http.setUser(user);
    }

    loginUser(nameUser: string, password: string): Observable<any> {
        this.http.sessionData.setAuthToken(this.generateAuthString(nameUser, password));
        this.http.sessionData.setAmILogged(true);
        const peticion = globals.USER_BASEURL + nameUser;
        return this.http.get(peticion);
    }
    private generateAuthString(username: String, password: String) {
        return 'Basic ' + btoa(username + ':' + password);
    }
    logOut(): void {
        console.log('Implementar');
    }

}

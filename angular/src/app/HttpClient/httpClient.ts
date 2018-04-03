import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SessionData } from '../login/sessionData.entity';
import { User } from '../user/user.model';
import * as globals from '../globals';

@Injectable()
export class HttpClientBasicAuth {

    public sessionData: SessionData;


    constructor(private http: HttpClient) {
        this.sessionData = new SessionData();
    }

    generateHeaders() {
        const headers = new HttpHeaders();

        if (this.sessionData.amILogged()) {
            headers.append('Authorization', this.sessionData.authToken());
        }

        return headers;
    }

    get(url) {
        return this.http.get(url, {
            headers: this.generateHeaders()
        });
    }


    post(url, data) {
        return this.http.post(url, data, {
            headers: this.generateHeaders()
        });
    }

    put(url, data) {
        return this.http.put(url, data, {
            headers: this.generateHeaders()
        });
    }

    delete(url) {
        return this.http.delete(url, {
            headers: this.generateHeaders()
        });
    }

    logOut() {
        /* return this.get(globals.LOGOUT_BASEURL).map(
             response => {
                 this.sessionData.reset();
             },
             error => console.log(error)
         );*/
    }

    setUser(u: User) {
        this.sessionData.setUserLogged(u);
        this.sessionData.setAmILogged(true);
        this.sessionData.saveData();
    }
}

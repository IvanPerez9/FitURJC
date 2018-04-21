import { Injectable} from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { SessionData } from '../login/sessionData.entity';
import { Observable } from 'rxjs/Observable';
import { User } from '../user/user.model';

@Injectable()
export class HttpClientBasicAuth {

    public sessionData: SessionData;


    constructor(private http: HttpClient) {
        this.sessionData = new SessionData();
    }

    generateHeaders() {
        if (this.sessionData.amILogged()) {
            let headers = new HttpHeaders();
            headers = headers.set('Authorization', this.sessionData.authToken());
            return headers;
        }
        return new HttpHeaders();
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

    patch(url, data) {
        return this.http.patch(url, data, {
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

    // See if is Admin
    setUser(u: User) {
        this.sessionData.setUserLogged(u);
        this.sessionData.setAmILogged(true);
        this.sessionData.setAmIAdmin(this.sessionData.getUserLogged().roles.indexOf("ROLE_ADMIN") > -1);
        this.sessionData.saveData();
    }

    sendImage(url: string, formdata: FormData): Observable<any>  {
        const req = new HttpRequest('POST', url, formdata, {
            reportProgress: true, headers: this.generateHeaders()
        });
        return this.http.request(req);
    }
}

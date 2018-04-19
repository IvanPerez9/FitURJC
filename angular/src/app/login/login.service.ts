import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { Http, Headers, RequestOptions } from '@angular/http';
import * as globals from '../globals';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
// import 'rxjs/Rx';

@Injectable()
export class LoginService {

    private session: string;
    private user: User;

    constructor(private http: HttpClientBasicAuth, private userService: UserService) { }

    public updateUser(username: String) {
        return this.userService.getUser(username).map(
            user => {

                this.http.setUser(user);
                return user;
            }
        );
    }

    public updateUserLogged(nick: String) {
        this.userService.getUser(nick).subscribe(
            user => {

                this.http.setUser(user);
            }
        );
    }
    // New test
    public getSessionHeader() {
        const headers = new Headers({'Authorization': this.getAuthHeader()});
        const options = new RequestOptions({ headers: headers });

        return options;
    }
    public getAuthHeader() {
        return this.session;
    }
    // End New
    public generateAuthString(username: String, password: String) {
        return 'Basic ' + btoa(username + ':' + password);
    }

    public logIn(username: string, password: string) {

        this.http.sessionData.setAuthToken(this.generateAuthString(username, password));

        // CREEMOS que estamos logeados, hasta que Spring diga lo contrario.
        // Necesario para que HTTP Client pruebe las nuevas cabeceras de autenticacion

        this.http.sessionData.setAmILogged(true);

        /* return this._http.get(globals.LOGIN_BASEURL).map(
             response => this.updateUser(username).subscribe())
             .catch(error => this.loginFailed(error));*/
        return null;

    }

    public loginFailed(error: any) {
        this.http.sessionData.setAmILogged(false);
        return Observable.throw('Server error (' + error.status + '): ' + error.text());
    }
    public logOut() {

        if (!this.isLogged()) { return; }

        return this.http.logOut();
    }

    public isLogged() {
        return this.http.sessionData.amILogged();
    }

    public isAdmin() {
        return this.isLogged() && this.http.sessionData.amIAdmin();
    }

    public getUser() {
        return this.http.sessionData.getUserLogged();
    }

    public forceUpdateUser() {

        return this.updateUserLogged(this.http.sessionData.getUserLogged().nickname);
    }

    public setNotLogged() {
        return this.http.sessionData.setNotLogged();
    }
    public User(){
      if(this.isLogged()){
        return this.getUser();
      }
    }
}

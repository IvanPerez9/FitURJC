import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
import { UserRegister} from '../register/register.component';
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
    /*
    NEW
    */

    public editUser(user: User) {
       // return this.http.put(this.url, JSON.stringify(user), this.loginService.getSessionHeader()).map(response => response.json());
       return this.http.put(this.url, JSON.stringify(user));
    }
    // Por ID ???????
    public deleteUser(user: User) {
        // return this.http.delete(this.url, this.loginService.getSessionHeader()).map(response => response.json());
        return this.http.delete(this.url);
    }

    setUserLogged(user: User) {
        this.http.setUser(user);
    }

    loginUser(email: string, password: string): Observable<any> {
        this.http.sessionData.setAuthToken(this.generateAuthString(email, password));
        this.http.sessionData.setAmILogged(true);
        const peticion = globals.USER_BASEURL + email;
        return this.http.get(peticion);
    }
    /*
    registerUser(nameUser: string, password: string, nick: string, email: string, surname: string): Observable<any> {
        this.http.sessionData.setAuthToken(this.generateAuthString(nameUser, password));
        this.http.sessionData.setAmILogged(true);
        const peticion = globals.USER_BASEURL + nameUser;
        return this.http.get(peticion);
    }
    */

   registerUser(user: UserRegister): any {
    const url = globals.USER_REGISTER;
    return this.http.post(url, user);
    }

    private generateAuthString(username: String, password: String) {
        return 'Basic ' + btoa(username + ':' + password);
    }
    logOut(): void {
        console.log('Implementar');
    }

}

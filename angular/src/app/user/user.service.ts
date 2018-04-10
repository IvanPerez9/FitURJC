import { Injectable } from '@angular/core';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { Observable } from 'rxjs/Observable';
import { UserRegister } from '../register/register.component';
// tslint:disable-next-line:import-blacklist
import 'rxjs/Rx';
import * as globals from '../globals';
import { User } from './user.model';
import { map } from 'rxjs/operators';

@Injectable()
export class UserService {

    url: string;
    user: User;

    constructor(private http: HttpClientBasicAuth) {
    }

    getUsers(): Observable<any> {
        let url = globals.USER_BASEURL;
        return this.http.get(url);
    }

    getUser(email: String): Observable<any> {
        let url = globals.USER_BASEURL;
        return this.http.get(url + email);
    }

    getUserByNickname(nickname: string): Observable<any> {
        let url = globals.USER_BASEURL;
        return this.http.get(url + nickname);
    }

    getUserById(userId: number): Observable<any> {
        let url = globals.USER_BASEURL;
        return this.http.get(url + userId);
    }

    createUser(user: User) {
        let url = globals.USER_BASEURL;
        return this.http.post(url, user);
    }

    editUser(userId: number, user: User) {
        let url = globals.USER_BASEURL;
        return this.http.put(url + userId, user);
    }

    // Avatar

    getUserAvatar(userId: number) {
        let url = globals.USER_BASEURL;
        return this.http.get(url + userId + '/avatar');
    }

    setUserAvatar(userId: number, formData: FormData) {
        let url = globals.USER_BASEURL;
        return this.http.put(url + userId + '/avatar', formData);
    }

    setAvatar(nickname: string, formData: FormData) {
        let url = globals.USER_BASEURL;
        return this.http.put(url + nickname + '/avatar', formData);
    }

    // public deleteUser(user: User) {
    //     return this.http.delete(this.url);
    // }
    // DIRECTO AL ADMIN CONTROL USERS (PARA DANI)

    setUserLogged(user: User) {
        this.http.setUser(user);
    }

    getLoggedUser(): User {
        return this.http.sessionData.getUserLogged();
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
        console.log('LogOut');
        this.http.sessionData.reset();
    }

    private errors(error: any) {
        console.error(error);
        return Observable.throw('Error (' + error.status + '): ' + error.text());
    }

}

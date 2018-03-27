import { User } from '../user/user.model';

interface SessionDataInterface {
    amILogged: boolean;
    amIAdmin: boolean;
    userLogged: User;
    authToken: string;
}

export class SessionData {

    sessionData: SessionDataInterface;

    testBrowser: boolean;

    public storageAvailable() {
        const x = '__storage_test__';
        window.localStorage.setItem(x, x);
        window.localStorage.removeItem(x);
        return true;
    }

    constructor() {
        this.loadData();
    }

    public reset() {
        this.sessionData = {
            amILogged: false, amIAdmin: false, userLogged: {
                userId: 0, email: 'a@a', nick: '', photo: '', roles: [''],
            }, authToken: ''
        };
        if (typeof window !== 'undefined') {
            window.localStorage.setItem('sessionDataaa', JSON.stringify(this.sessionData));
        }
    }

    public amILogged() {
        return this.sessionData.amILogged;
    }

    public setNotLogged() {
        return this.sessionData.amILogged = false;
    }

    public amIAdmin() {
        return this.sessionData.amIAdmin;
    }

    public authToken() {
        return this.sessionData.authToken;
    }

    public setAuthToken(auth) {
        this.sessionData.authToken = auth;
    }

    public setUserLogged(u) {
        this.sessionData.userLogged = u;
    }

    public getUserLogged() {
        return this.sessionData.userLogged;
    }

    public setAmIAdmin(b) {
        this.sessionData.amIAdmin = b;
    }

    public setAmILogged(b) {
        this.sessionData.amILogged = b;
    }

    public saveData() {
        if (this.sessionData.amILogged && typeof window !== 'undefined') {
            console.log('Guardando ifo de la sesión');
            window.localStorage.setItem('sessionDataaa', JSON.stringify(this.sessionData));
        }
    }

    public destroyData() {
        if (typeof window !== 'undefined') {
            window.localStorage.removeItem('sessionDataaa');
        }
    }

    public loadData() {
        console.log('Trying to load session data from storage....');
        if (typeof window !== 'undefined') {
            this.sessionData = JSON.parse(window.localStorage.getItem('sessionDataaa'));
        }
        if (this.sessionData === undefined || this.sessionData === null) {
            console.log('Data not found, using new session');
            this.reset();
        }

    }
}

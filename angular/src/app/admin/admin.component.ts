import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { User } from '../user/user.model';
import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-admin',  // Mirar lo del kebab case, tsconfig
    templateUrl: './admin.component.html',
    styleUrls: ['./admin.component.css']
})
export class AdminComponent {
    public msgs: any[] = [];

    constructor(private sessionService: LoginService, private router: Router) {
        this.msgs.push({ severity: 'infor', summary: '¡¡Eres Administrador!!' });
    }

    ngOnInit() {
        let admin: boolean;
        if (this.sessionService.isLogged()) {
            if (this.sessionService.isAdmin()) {
                console.log('Admin');
                admin = true;
                return this.router.navigate(['/admin']);
            } else {
                console.log('Not Admin');
                admin = false;
                return this.router.navigate(['/user/profile']);
            }
        } else {
            console.log('No even Logged');
            admin = false;
            return this.router.navigate(['/login']);
        }
    }

}

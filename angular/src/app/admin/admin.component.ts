import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login/login.service';
import { User } from '../user/user.model';

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
}

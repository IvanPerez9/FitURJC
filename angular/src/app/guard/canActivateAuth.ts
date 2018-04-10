import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { CanActivate } from '@angular/router';
import { LoginService } from '../login/login.service';

@Injectable()
export class CanActivateAuth implements CanActivate {

    constructor(private authService: LoginService, private router: Router) { }

    canActivate() {
        // If the user logged in we'll send them back to the home page
        if (this.authService.isLogged()) {
            console.log('Bienvenido de nuevo');
            this.router.navigate(['/home']);
            return false;
        }

        return true;
    }
}

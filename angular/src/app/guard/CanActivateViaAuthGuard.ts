import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { CanActivateChild } from '@angular/router';
import { LoginService } from '../login/login.service';

@Injectable()
export class CanActivateViaAuthGuard implements CanActivateChild {

    constructor(private authService: LoginService, private router: Router) { }

    canActivateChild() {
        // If the user is not logged in we'll send them back to the home page
        if (!this.authService.isLogged()) {
            console.log('No estás logueado');
            this.router.navigate(['/']);
            return false;
        }

        return true;
    }
}

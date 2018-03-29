import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';

const appRoutes = [
    { path: '', component: HomeComponent, pathMatch: 'full' },
    { path: 'user', component: UserComponent },
    { path: 'login', component: LoginComponent },

];

export const appRoutingProviders: any[] = [];
export const routing = RouterModule.forRoot(appRoutes);

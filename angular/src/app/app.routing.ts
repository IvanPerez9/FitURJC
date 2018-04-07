import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';
import { FacilitiesComponent } from './facilities/facilities.component';
import { AdminControlUsersComponent } from './admin/admin-control-users/admin-control-users.component';
import { AdminControlCoursesComponent } from './admin/admin-control-courses/admin-control-courses.component';

import {ProfileComponent} from "./profile/profile.component";


export const appRoutes = [
    { path: '', component: HomeComponent, pathMatch: 'full' },
    { path: 'user', component: UserComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'admin', component: AdminComponent,
    children: [
        { path: 'controlUsers', component: AdminControlUsersComponent },
        { path: 'controlCourses', component: AdminControlCoursesComponent }
    ] },
    { path: 'profile', component: UserComponent },
    { path: 'facilities', component: FacilitiesComponent },
    { path: 'editProfile', component: ProfileComponent }

];


@NgModule({
    imports: [ RouterModule.forRoot(appRoutes) ],
    exports: [ RouterModule ]
  })
  export class AppRoutingModule {}

export const appRoutingProviders: any[] = [];
export const routing = RouterModule.forRoot(appRoutes);




import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing, appRoutingProviders } from './app.routing';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { AppRoutingModule } from '../app/app.routing';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { UserService } from './user/user.service';
import { LoginService } from './login/login.service';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientBasicAuth } from './HttpClient/httpClient';
import { CourseComponent } from './course/course.component';
<<<<<<< HEAD
import { ScheduleComponent } from './schedule/schedule.component';
import { RecomendationComponent } from './recomendation/recomendation.component';
import { FacilitiesComponent } from './facilities/facilities.component';
=======
import { AdminComponent } from './admin/admin.component';
>>>>>>> 3252b8bba58a4e6197c61d8a47e0dc994357285a


@NgModule({
  imports: [
    BrowserModule,
    routing,
    FormsModule,
    AppRoutingModule,
  ],
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    UserComponent,
    LoginComponent,
    RegisterComponent,
    CourseComponent,
<<<<<<< HEAD
    ScheduleComponent,
    RecomendationComponent,
    FacilitiesComponent
  ],
  imports: [
    BrowserModule,
    routing,
    FormsModule
=======
    AdminComponent,
>>>>>>> 3252b8bba58a4e6197c61d8a47e0dc994357285a
  ],
  providers: [appRoutingProviders, HttpClientBasicAuth, UserService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }

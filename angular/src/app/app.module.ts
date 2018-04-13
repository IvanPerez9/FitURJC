import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing, appRoutingProviders } from './app.routing';
import { FormsModule } from '@angular/forms'; 
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from '../app/app.routing';
import { AppComponent } from './app.component';
import { HttpClientBasicAuth } from './HttpClient/httpClient';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { NavbarCourseProfileComponent } from './navbar-course-profile/navbar-course-profile.component';
import { NavbarProfileComponent } from './navbar-profile/navbar-profile.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { UserService } from './user/user.service';
import { LoginService } from './login/login.service';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { EditProfileComponent } from './editProfile/editProfile.component';
import { AdminComponent } from './admin/admin.component';
import { AdminControlUsersComponent } from './admin/admin-control-users/admin-control-users.component';
import { AdminControlCoursesComponent } from './admin/admin-control-courses/admin-control-courses.component';
import { AddCoursesComponent } from './admin/add-courses/add-courses.component';
import { AdminGraphicsComponent } from './admin/admin-graphics/admin-graphics.component';
import { CourseProfileService } from './course-profile/course-profile.service';
import { CourseProfileComponent } from './course-profile/course-profile.component';
import { CourseComponent } from './course/course.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { ScheduleService } from './schedule/schedule.service';
import { RecomendationComponent } from './recomendation/recomendation.component';
import { FacilitiesComponent } from './facilities/facilities.component';

//blacklist
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { DropdownModule } from 'angular-custom-dropdown';
import { ChartsModule } from 'ng2-charts';
import { NgProgressModule, NgProgressBrowserXhr } from 'ngx-progressbar';
import { HttpModule } from '@angular/http';
import { BrowserXhr } from '@angular/http';
import { Maps } from './maps/maps.component';
import { AgmCoreModule } from '@agm/core';
import { ScrollToModule } from "ng2-scroll-to";
import { Ng4LoadingSpinnerModule } from 'ng4-loading-spinner';





@NgModule({
  imports: [
    BrowserModule,
    routing,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    DropdownModule,
    InfiniteScrollModule,
    ChartsModule,
    NgProgressModule,
    HttpModule,
    BrowserModule,
    ReactiveFormsModule,
    Ng4LoadingSpinnerModule.forRoot(),
    ScrollToModule.forRoot(),
    AgmCoreModule.forRoot({
      // please get your own API key here:
      // https://developers.google.com/maps/documentation/javascript/get-api-key?hl=en
      apiKey: 'AIzaSyCCSoAdbLDLW9tKqwjt-H4FkBNl8HhRUFM'
    })
  ],
  declarations: [
    AppComponent,
    AdminComponent,
    NavbarComponent,
    HomeComponent,
    UserComponent,
    LoginComponent,
    RegisterComponent,
    CourseComponent,
    ScheduleComponent,
    RecomendationComponent,
    FacilitiesComponent,
    AdminControlUsersComponent,
    AdminControlCoursesComponent,
    AdminGraphicsComponent,
    AddCoursesComponent,
    EditProfileComponent,
    NavbarProfileComponent,
    CourseProfileComponent,
    NavbarCourseProfileComponent,
    Maps,
    AddCoursesComponent
  ],
  providers: [appRoutingProviders, HttpClientBasicAuth, UserService, LoginService, CourseProfileService, ScheduleService, {provide: BrowserXhr, useClass:NgProgressBrowserXhr}],
  bootstrap: [AppComponent]
})
export class AppModule { }

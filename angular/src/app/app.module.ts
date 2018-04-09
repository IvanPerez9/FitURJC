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
import { ScheduleComponent } from './schedule/schedule.component';
import { RecomendationComponent } from './recomendation/recomendation.component';
import { FacilitiesComponent } from './facilities/facilities.component';
import { AdminComponent } from './admin/admin.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminControlUsersComponent } from './admin/admin-control-users/admin-control-users.component';
import { AdminControlCoursesComponent } from './admin/admin-control-courses/admin-control-courses.component';
import { AdminGraphicsComponent } from './admin/admin-graphics/admin-graphics.component';
// import { SidebarComponent } from './admin/sidebar/sidebar.component';
// import { HeaderComponent } from './admin/header/header.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ProfileComponent } from './profile/profile.component';
import { CourseService } from './course/course.service';
import { NavbarProfileComponent } from './navbar-profile/navbar-profile.component';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { DropdownModule } from 'angular-custom-dropdown';



@NgModule({
  imports: [
    BrowserModule,
    routing,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    DropdownModule
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
    ProfileComponent,
    NavbarProfileComponent
  ],
  providers: [appRoutingProviders, HttpClientBasicAuth, UserService, LoginService, CourseService],
  bootstrap: [AppComponent]
})
export class AppModule { }

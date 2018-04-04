import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing, appRoutingProviders } from './app.routing';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { AppRoutingModule } from '../app/app.routing'
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
import { AdminComponent } from './admin/admin.component';


@NgModule({
  imports: [
    BrowserModule,
    routing,
    FormsModule,
    AppRoutingModule
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
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    routing,
    FormsModule
=======
>>>>>>> b63411856f3c5ee77a04036fe4702a168c088932
  ],
  providers: [appRoutingProviders, HttpClientBasicAuth, UserService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }

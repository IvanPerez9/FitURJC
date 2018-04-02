import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing ,appRoutingProviders} from './app.routing';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';
import { UserService } from './user/user.service';
import { LoginService } from './login/login.service';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HttpClient } from './HttpClient/httpClient';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    UserComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    routing
  ],
  providers: [appRoutingProviders, HttpClient, UserService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }

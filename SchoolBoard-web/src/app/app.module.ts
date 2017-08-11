import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { routing } from './app.routing';

import { AlertComponent } from './_directives/index';
import { AuthGuard } from './_guards/index';
import { AlertService, AuthenticationService, UserService } from './_services/index';
import { HomeComponent } from './home/index';
import { LoginComponent } from './classes/login';
import { RegisterComponent } from './register/index';


@NgModule({
  declarations: [
    AppComponent
    HomeComponent,
    LoginComponent,
     RegisterComponent
  ],
  imports: [
    BrowserModule,
    routing
  ],

  providers: [
   AlertService,
   AuthenticationService,
   UserService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

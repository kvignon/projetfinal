import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisterRoutingModule } from './register-routing.module';
import { RegisterComponent } from './register.component';
import { PageHeaderModule } from './../../shared';

 @NgModule ({
  imports: [
    CommonModule,
    RegisterRoutingModule,
    PageHeaderModule
  ],
  declarations: [RegisterComponent]
})
export class RegisterModule { }
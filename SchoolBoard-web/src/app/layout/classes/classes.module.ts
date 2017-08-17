import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClassesRoutingModule } from './classes-routing.module';
import { ClassesComponent } from './classes.component';
import { PageHeaderModule } from './../../shared';

 @NgModule ({
  imports: [
    CommonModule,
    ClassesRoutingModule,
    PageHeaderModule
  ],
  declarations: [ClassesComponent]
})
export class ClassesModule { }
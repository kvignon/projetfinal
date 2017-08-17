import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SalleRoutingModule } from '../salle/salle-routing.module';
import { SalleComponent } from '../salle/salle.component';
import { PageHeaderModule } from '../../shared';

 @NgModule ({
  imports: [
    CommonModule,
   SalleRoutingModule,
    PageHeaderModule
  ],
  declarations: [SalleComponent]
})
export class SalleModule { }
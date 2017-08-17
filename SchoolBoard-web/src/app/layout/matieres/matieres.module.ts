import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MatieresRoutingModule } from './matieres-routing.module';
import { MatieresComponent } from './matieres.component';
import { PageHeaderModule } from './../../shared';

 @NgModule ({
  imports: [
    CommonModule,
    MatieresRoutingModule,
    PageHeaderModule
  ],
  declarations: [MatieresComponent]
})
export class MatieresModule { }
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EtablissementRoutingModule } from './etablissement-routing.module';
import { EtablissementComponent } from './etablissement.component';
import { PageHeaderModule } from './../../shared';

 @NgModule ({
  imports: [
    CommonModule,
    EtablissementRoutingModule,
    PageHeaderModule
  ],
  declarations: [EtablissementComponent]
})
export class EtablissementModule { }
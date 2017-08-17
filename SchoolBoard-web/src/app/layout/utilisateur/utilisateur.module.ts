import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UtilisateurRoutingModule } from './utilisateur-routing.module';
import { UtilisateurComponent } from './utilisateur.component';
import { PageHeaderModule } from '../../shared';

 @NgModule ({
  imports: [
    CommonModule,
   UtilisateurRoutingModule,
    PageHeaderModule
  ],
  declarations: [UtilisateurComponent]
})
export class UtilisateurModule { }
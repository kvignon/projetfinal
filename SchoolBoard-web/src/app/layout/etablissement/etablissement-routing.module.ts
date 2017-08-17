import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { EtablissementComponent } from './etablissement.component';

const routes: Routes = [
    { path: '', component: EtablissementComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EtablissementRoutingModule { }

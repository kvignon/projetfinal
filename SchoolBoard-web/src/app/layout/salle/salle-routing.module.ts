import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SalleComponent } from '../salle/salle.component';

const routes: Routes = [
    { path: '', component: SalleComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SalleRoutingModule { }

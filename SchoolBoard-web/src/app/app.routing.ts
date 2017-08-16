import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';



const appRoutes: Routes = [
   { path: '', redirectTo: 'pages', pathMatch: 'full' },
  { path: '**', redirectTo: 'pages/dashboard' }

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes,
{ useHash: true });

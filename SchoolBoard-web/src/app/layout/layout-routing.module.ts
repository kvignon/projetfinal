import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';

const routes: Routes = [
    {
        path: '', component: LayoutComponent,
        children: [ 
            { path: 'dashboard', loadChildren: './dashboard/dashboard.module#DashboardModule' },
            { path: 'charts', loadChildren: './charts/charts.module#ChartsModule' },
            { path: 'tables', loadChildren: './tables/tables.module#TablesModule' },
            { path: 'forms', loadChildren: './form/form.module#FormModule' },
            { path: 'bs-element', loadChildren: './bs-element/bs-element.module#BsElementModule' },
            { path: 'grid', loadChildren: './grid/grid.module#GridModule' },
            { path: 'components', loadChildren: './bs-component/bs-component.module#BsComponentModule' },
            { path: 'register', loadChildren: './register/register.module#RegisterModule' },
            { path: 'utilisateur', loadChildren: './utilisateur/utilisateur.module#UtilisateurModule' },
            { path: 'etablissement', loadChildren: './etablissement/etablissement.module#EtablissementModule' },
            { path: 'salle', loadChildren: './salle/salle.module#SalleModule' },
            { path: 'classes', loadChildren: './classes/classes.module#ClassesModule' },
            { path: 'matieres', loadChildren: './matieres/matieres.module#MatieresModule' }
            
            
           
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class LayoutRoutingModule { }

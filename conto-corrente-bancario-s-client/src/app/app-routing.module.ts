import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AssociaCcComponent } from './associa-cc/associa-cc.component';
import { AssociaCdComponent } from './associa-cd/associa-cd.component';
import { AssociaCpComponent } from './associa-cp/associa-cp.component';
import { GestioneCcComponent } from './gestione-cc/gestione-cc.component';
import { GestioneCdComponent } from './gestione-cd/gestione-cd.component';
import { GestioneClientiComponent } from './gestione-clienti/gestione-clienti.component';
import { GestioneCpComponent } from './gestione-cp/gestione-cp.component';
import { HomePageComponent } from './home-page/home-page.component';
import { MostraTuttiIContiComponent } from './mostra-tutti-i-conti/mostra-tutti-i-conti.component';

const routes: Routes = [
  { path: 'app-home-page', component: HomePageComponent },
  { path: 'app-gestione-cc', component: GestioneCcComponent },
  { path: 'app-gestione-clienti', component: GestioneClientiComponent },  
  { path: 'app-gestione-cp', component: GestioneCpComponent },
  { path: 'app-gestione-cd', component: GestioneCdComponent },
  { path: 'app-mostra-tutti-i-conti', component: MostraTuttiIContiComponent },
  { path: 'app-associa-cc', component: AssociaCcComponent },
  { path: 'app-associa-cp', component: AssociaCpComponent },
  { path: 'app-associa-cd', component: AssociaCdComponent },
  { path: '', redirectTo: '/app-home-page', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

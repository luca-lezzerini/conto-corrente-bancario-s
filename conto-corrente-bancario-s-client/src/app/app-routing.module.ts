import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AssociaCcComponent } from './associa-cc/associa-cc.component';
import { AssociaCdComponent } from './associa-cd/associa-cd.component';
import { AssociaCpComponent } from './associa-cp/associa-cp.component';
import { EstrattoContoCcComponent } from './estratto-conto-cc/estratto-conto-cc.component';
import { EstrattoContoCdComponent } from './estratto-conto-cd/estratto-conto-cd.component';
import { EstrattoContoCpComponent } from './estratto-conto-cp/estratto-conto-cp.component';
import { GestioneCcComponent } from './gestione-cc/gestione-cc.component';
import { GestioneCdComponent } from './gestione-cd/gestione-cd.component';
import { GestioneClientiComponent } from './gestione-clienti/gestione-clienti.component';
import { GestioneCpComponent } from './gestione-cp/gestione-cp.component';
import { HomePageComponent } from './home-page/home-page.component';
import { MostraTuttiIContiComponent } from './mostra-tutti-i-conti/mostra-tutti-i-conti.component';
import { MovimentaCcComponent } from './movimenta-cc/movimenta-cc.component';
import { MovimentaCdComponent } from './movimenta-cd/movimenta-cd.component';
import { MovimentaCpComponent } from './movimenta-cp/movimenta-cp.component';
import { SaldoCcComponent } from './saldo-cc/saldo-cc.component';
import { SaldoCdComponent } from './saldo-cd/saldo-cd.component';
import { SaldoCpComponent } from './saldo-cp/saldo-cp.component';

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
  { path:'app-movimenta-cc', component: MovimentaCcComponent },
  { path:'app-movimenta-cp', component: MovimentaCpComponent },
  { path:'app-movimenta-cd', component: MovimentaCdComponent },
  { path:'app-saldo-cc', component: SaldoCcComponent },
  { path:'app-saldo-cp', component: SaldoCpComponent },
  { path:'app-saldo-cd', component: SaldoCdComponent },
  { path:'app-estratto-conto-cc', component: EstrattoContoCcComponent },
  { path:'app-estratto-conto-cp', component: EstrattoContoCpComponent },
  { path:'app-estratto-conto-cd', component: EstrattoContoCdComponent },




  { path: '', redirectTo: '/app-home-page', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

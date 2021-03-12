import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GestioneCcComponent } from './gestione-cc/gestione-cc.component';
import { HomePageComponent } from './home-page/home-page.component';
import { GestioneClientiComponent } from './gestione-clienti/gestione-clienti.component';
import { GestioneCpComponent } from './gestione-cp/gestione-cp.component';
import { GestioneCdComponent } from './gestione-cd/gestione-cd.component';
import { MostraTuttiIContiComponent } from './mostra-tutti-i-conti/mostra-tutti-i-conti.component';
import { AssociaCcComponent } from './associa-cc/associa-cc.component';
import { AssociaCpComponent } from './associa-cp/associa-cp.component';
import { AssociaCdComponent } from './associa-cd/associa-cd.component';
import { MovimentaCcComponent } from './movimenta-cc/movimenta-cc.component';
import { MovimentaCpComponent } from './movimenta-cp/movimenta-cp.component';
import { MovimentaCdComponent } from './movimenta-cd/movimenta-cd.component';
import { SaldoCcComponent } from './saldo-cc/saldo-cc.component';
import { SaldoCpComponent } from './saldo-cp/saldo-cp.component';
import { SaldoCdComponent } from './saldo-cd/saldo-cd.component';
import { EstrattoContoCcComponent } from './estratto-conto-cc/estratto-conto-cc.component';
import { EstrattoContoCpComponent } from './estratto-conto-cp/estratto-conto-cp.component';
import { EstrattoContoCdComponent } from './estratto-conto-cd/estratto-conto-cd.component';

@NgModule({
  declarations: [
    AppComponent,
    GestioneCcComponent,
    HomePageComponent,
    GestioneClientiComponent,
    GestioneCpComponent,
    GestioneCdComponent,
    MostraTuttiIContiComponent,
    AssociaCcComponent,
    AssociaCpComponent,
    AssociaCdComponent,
    MovimentaCcComponent,
    MovimentaCpComponent,
    MovimentaCdComponent,
    SaldoCcComponent,
    SaldoCpComponent,
    SaldoCdComponent,
    EstrattoContoCcComponent,
    EstrattoContoCpComponent,
    EstrattoContoCdComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

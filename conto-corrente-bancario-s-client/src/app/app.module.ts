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
    AssociaCdComponent
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

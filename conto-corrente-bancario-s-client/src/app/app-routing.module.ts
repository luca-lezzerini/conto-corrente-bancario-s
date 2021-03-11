import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InserisciComponent } from './inserisci/inserisci.component';

const routes: Routes = [
  { path: 'inserisci-page', component: InserisciComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

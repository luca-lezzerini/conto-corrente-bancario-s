import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { InserisciComponent } from './inserisci/inserisci.component';

const routes: Routes = [
  { path: 'app-inserisci', component: InserisciComponent },
  { path: 'app-home-page', component: HomePageComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

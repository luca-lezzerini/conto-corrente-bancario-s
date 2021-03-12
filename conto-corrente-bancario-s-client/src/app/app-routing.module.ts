import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GestioneCcComponent } from './gestione-cc/gestione-cc.component';
import { HomePageComponent } from './home-page/home-page.component';

const routes: Routes = [
  { path: 'app-home-page', component: HomePageComponent },
  { path: 'app-gestione-cc', component: GestioneCcComponent },
  { path: '', redirectTo: '/app-home-page', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  gestioneClienti() {
    this.router.navigateByUrl('/app-gestione-clienti')
  }
  gestioneCC() {
    this.router.navigateByUrl('/app-gestione-cc')
  }

  gestioneCP() {
    this.router.navigateByUrl('/app-gestione-cp')
  }

  gestioneCD() {
    this.router.navigateByUrl('/app-gestione-cd')
  }

  mostraTuttiConti() {
    this.router.navigateByUrl('/app-mostra-tutti-i-conti')
  }

  associaCC() {
    this.router.navigateByUrl('/app-associa-cc')
  }

  associaCP() {
    this.router.navigateByUrl('/app-associa-cp')
  }

  associaCD() {
    this.router.navigateByUrl('/app-associa-cd')
  }

}

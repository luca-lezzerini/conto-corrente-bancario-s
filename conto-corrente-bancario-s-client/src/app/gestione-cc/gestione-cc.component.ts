import { HttpClient } from '@angular/common/http';
import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { ContoCorrente } from './cc';

@Component({
  selector: 'app-gestione-cc',
  templateUrl: './gestione-cc.component.html',
  styleUrls: ['./gestione-cc.component.css']
})
export class GestioneCcComponent implements OnInit {
  cc: ContoCorrente[] = [];
  conto = new ContoCorrente();

  constructor(private route: Route, private http: HttpClient) { }
  // showForm = false;
  ngOnInit(): void {
  }

  new() {
    // this.showForm = true;
  }

  aggiungi() {

  }
}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ContoPrestito } from '../conto-prestito';

@Component({
  selector: 'app-gestione-cp',
  templateUrl: './gestione-cp.component.html',
  styleUrls: ['./gestione-cp.component.css']
})
export class GestioneCpComponent implements OnInit {
  contoPrestito: ContoPrestito = new ContoPrestito();
  showFormChoice: boolean = false;
  codici: ContoPrestito[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  new() {

  }

  add() {

  }
  edit() {
    this.showFormChoice = true;
  }
  delete() {

  }



}

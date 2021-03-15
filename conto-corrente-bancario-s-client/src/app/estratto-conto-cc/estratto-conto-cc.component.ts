import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';

@Component({
  selector: 'app-estratto-conto-cc',
  templateUrl: './estratto-conto-cc.component.html',
  styleUrls: ['./estratto-conto-cc.component.css','../app.component.css']
})
export class EstrattoContoCcComponent implements OnInit {
  ricercaCliente = "";
  clienti: Cliente[] = [];
  contiCorrente: ContoCorrente[] = [];
  constructor() { }

  ngOnInit(): void {
  }

  cercaCliente() {

  }
  seleziona() {

  }
  estrattoConto() {

  }
}

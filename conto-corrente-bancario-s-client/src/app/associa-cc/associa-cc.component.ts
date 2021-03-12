import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';

@Component({
  selector: 'app-associa-cc',
  templateUrl: './associa-cc.component.html',
  styleUrls: ['./associa-cc.component.css']
})
export class AssociaCcComponent implements OnInit {

  clienti: Cliente[] = [];
  cliente = new Cliente();
  contiCorrente: ContoCorrente[] = [];
  numeroConto = "";
  constructor() { }

  ricercaCliente = "";
  ngOnInit(): void {
  }

  cercaCliente() {

  }

  cercaContoCorrente() {

  }
}

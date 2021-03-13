import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';

@Component({
  selector: 'app-saldo-cc',
  templateUrl: './saldo-cc.component.html',
  styleUrls: ['./saldo-cc.component.css']
})
export class SaldoCcComponent implements OnInit {
  clienti: Cliente[] = [];
  contiDeposito: ContoCorrente[] = [];
  ricercaCliente = "";
  showTableSaldo = false;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    this.http.post<ListaClientiDto>("http://localhost:8080/ricerca-cliente-saldo-cc", dto)
      .subscribe(r => this.clienti = r.listaClienti);
  }

  seleziona(c: Cliente) {
    this.showTableSaldo = true;
  }

  saldo(cc: ContoCorrente) {
    
  }
}

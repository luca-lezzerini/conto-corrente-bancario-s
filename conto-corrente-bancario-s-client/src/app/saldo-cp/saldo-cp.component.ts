import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoPrestito } from '../conto-prestito';
import { ClienteDto } from '../dto/cliente-dto';
import { ContoPrestitoDto } from '../dto/conto-prestito-dto';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';
import { TuttiContiDto } from '../dto/tutti-conti-dto';

@Component({
  selector: 'app-saldo-cp',
  templateUrl: './saldo-cp.component.html',
  styleUrls: ['./saldo-cp.component.css']
})
export class SaldoCpComponent implements OnInit {
  clienti: Cliente[] = [];
  contiPrestito: ContoPrestito[] = [];
  ricercaCliente = "";
  showTableSaldo = false;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    this.http.post<ListaClientiDto>("http://localhost:8080/ricerca-cliente-saldo-cp", dto)
      .subscribe(r => this.clienti = r.listaClienti);
  }

  seleziona(c: Cliente) {
    this.showTableSaldo = true;
    let dto = new ClienteDto();
    dto.cliente = c;
    this.http.post<TuttiContiDto>("http://localhost:8080/ricerca-conti-associati-cp", dto)
      .subscribe(r => this.contiPrestito = r.contiPrestito);
  }

  saldoCP(cc: ContoPrestito) {
    let dto = new ContoPrestitoDto();
    dto.contoPrestito = cc;
    this.http.post<TuttiContiDto>("http://localhost:8080/visualizza-saldo-cp", dto)
      .subscribe(r => this.contiPrestito = r.contiPrestito);
  }
}

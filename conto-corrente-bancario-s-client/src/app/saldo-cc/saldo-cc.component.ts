import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { ClienteDto } from '../dto/cliente-dto';
import { ContoCorrenteDto } from '../dto/conto-corrente-dto';
import { ContoDepositoDto } from '../dto/conto-deposito-dto';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';
import { TuttiContiDto } from '../dto/tutti-conti-dto';

@Component({
  selector: 'app-saldo-cc',
  templateUrl: './saldo-cc.component.html',
  styleUrls: ['./saldo-cc.component.css']
})
export class SaldoCcComponent implements OnInit {
  clienti: Cliente[] = [];
  contiCorrente: ContoCorrente[] = [];
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
    let dto = new ClienteDto();
    dto.cliente = c;
    this.http.post<TuttiContiDto>("http://localhost:8080/ricerca-conti-associati-cc", dto)
      .subscribe(r => this.contiCorrente = r.contiCorrenti);
  }

  saldo(cc: ContoCorrente) {
    let dto = new ContoCorrenteDto();
    dto.contoCorrente = cc;
    this.http.post<TuttiContiDto>("http://localhost:8080/visualizza-saldo-cc", dto)
      .subscribe(r => this.contiCorrente = r.contiCorrenti);
  }
}

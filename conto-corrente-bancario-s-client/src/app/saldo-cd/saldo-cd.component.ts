import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoDeposito } from '../conto-deposito';
import { ClienteDto } from '../dto/cliente-dto';
import { ContoDepositoDto } from '../dto/conto-deposito-dto';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { MovimentoCdDto } from '../dto/movimento-cd-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';
import { SaldoCdDto } from '../dto/saldo-cd-dto';
import { TuttiContiDto } from '../dto/tutti-conti-dto';

@Component({
  selector: 'app-saldo-cd',
  templateUrl: './saldo-cd.component.html',
  styleUrls: ['./saldo-cd.component.css', '../app.component.css']
})
export class SaldoCdComponent implements OnInit {
  clienti: Cliente[] = [];
  contiDeposito: ContoDeposito[] = [];
  ricercaCliente = "";
  showTab2 = false;
  saldoT = 0;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    this.http.post<ListaClientiDto>("http://localhost:8080/ricerca-cliente-like", dto)
      .subscribe(r => this.clienti = r.listaClienti);
  }

  seleziona(c: Cliente) {
    this.saldoT = 0;
    this.showTab2 = true;
    let dto = new ClienteDto();
    dto.cliente = c;
    this.http.post<TuttiContiDto>("http://localhost:8080/ricerca-conti-associati-cliente", dto)
      .subscribe(r => this.contiDeposito = r.contiDeposito);
  }

  saldo(cc: ContoDeposito) {
    let dto = new MovimentoCdDto();
    dto.contoDeposito = cc;
    this.http.post<SaldoCdDto>("http://localhost:8080/saldo-cd", dto)
      .subscribe(r => this.saldoT = r.saldo);
  }
}

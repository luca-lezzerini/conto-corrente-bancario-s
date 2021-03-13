import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoDeposito } from '../conto-deposito';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';

@Component({
  selector: 'app-saldo-cd',
  templateUrl: './saldo-cd.component.html',
  styleUrls: ['./saldo-cd.component.css']
})
export class SaldoCdComponent implements OnInit {
  clienti: Cliente[] = [];
  contiDeposito: ContoDeposito[] = [];
  ricercaCliente = "";
  showTab2 = false;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    this.http.post<ListaClientiDto>("http://localhost:8080/ricerca-c", dto)
      .subscribe(r => this.clienti = r.listaClienti);
  }

  seleziona(c: Cliente) {
    this.showTab2 = true;
  }

  saldo(cc: ContoDeposito) {
  }
}

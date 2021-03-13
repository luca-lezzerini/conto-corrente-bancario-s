import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { ContoDeposito } from '../conto-deposito';
import { ContoPrestito } from '../conto-prestito';
import { ClienteDto } from '../dto/cliente-dto';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';
import { TuttiContiDto } from '../dto/tutti-conti-dto';

@Component({
  selector: 'app-estratto-conto-cd',
  templateUrl: './estratto-conto-cd.component.html',
  styleUrls: ['./estratto-conto-cd.component.css']
})
export class EstrattoContoCdComponent implements OnInit {

  ricercaCliente = "";
  clienti: Cliente[] = [];
  contiDeposito: ContoDeposito[] = [];
  contiCorrenti: ContoCorrente[] = [];
  contiPrestito: ContoPrestito[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cercaCliente() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    this.http.post<ListaClientiDto>("http://localhost:8080/ricerca-cliente-like", dto)
      .subscribe(r => this.clienti = r.listaClienti);
  }

  seleziona(c: Cliente) {
    let dto = new ClienteDto();
    dto.cliente = c;
    this.http.post<TuttiContiDto>("http://localhost:8080/ricerca-conti-associati-cliente", dto)
      .subscribe(tt => {
        this.contiDeposito = tt.contiDeposito;
      });
  }
}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { ContoDeposito } from '../conto-deposito';
import { ContoPrestito } from '../conto-prestito';
import { ClienteDto } from '../dto/cliente-dto';
import { ContoDepositoDto } from '../dto/conto-deposito-dto';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { ListaMovimentiCdDto } from '../dto/lista-movimenti-cd-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';
import { TuttiContiDto } from '../dto/tutti-conti-dto';
import { MovimentiContoDeposito } from '../movimenti-cd';

@Component({
  selector: 'app-estratto-conto-cd',
  templateUrl: './estratto-conto-cd.component.html',
  styleUrls: ['./estratto-conto-cd.component.css','../app.component.css']
})
export class EstrattoContoCdComponent implements OnInit {

  ricercaCliente = "";
  clienti: Cliente[] = [];
  contiDeposito: ContoDeposito[] = [];
  movimentiCd: MovimentiContoDeposito[] = [];


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

  estrattoConto(cd: ContoDeposito) {
    let dto = new ContoDepositoDto();
    dto.contoDeposito = cd;
    this.http.post<ListaMovimentiCdDto>("http://localhost:8080/ricerca-movimenti-cd", dto)
      .subscribe(c => this.movimentiCd = c.listaMovimentiCd);

  }
}

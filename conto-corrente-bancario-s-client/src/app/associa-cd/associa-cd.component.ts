import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { ContoDeposito } from '../conto-deposito';
import { ContoDepositoDto } from '../conto-deposito-dto';
import { ListaClientiDto } from '../lista-clienti-dto';
import { ListaContiCorrenteDto } from '../lista-conti-corrente-dto';
import { RicercaClienteDto } from '../ricerca-cliente-dto';
import { RicercaContoCorrenteDto } from '../ricerca-conto-corrente-dto';

@Component({
  selector: 'app-associa-cd',
  templateUrl: './associa-cd.component.html',
  styleUrls: ['./associa-cd.component.css']
})
export class AssociaCdComponent implements OnInit {

  clienti: Cliente[] = [];
  cliente = new Cliente();
  contoDeposito = new ContoDeposito();
  ricercaConto = "";
  ricercaCliente = "";
  cdTrovato = "";

  constructor(private http: HttpClient) { }


  ngOnInit(): void {
  }

  cercaCliente() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    this.http.post<ListaClientiDto>("http://localhost:8080/ricerca-c", dto)
      .subscribe(r => this.clienti = r.listaClienti);
  }

  cercaContoDeposito() {
    let dto = new RicercaContoCorrenteDto();
    dto.codiceEsatto = this.ricercaConto;
    this.http.post<ContoDepositoDto>("http://localhost:8080/ricerca-cd", dto)
      .subscribe(r => this.cdTrovato = r.contoDeposito.codice);
  }

  associa(){
    
  }

}

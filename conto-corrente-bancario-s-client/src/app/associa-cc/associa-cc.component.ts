import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { ContoCorrenteDto } from '../conto-corrente-dto';
import { ListaClientiDto } from '../lista-clienti-dto';
import { ListaContiCorrenteDto } from '../lista-conti-corrente-dto';
import { RicercaClienteDto } from '../ricerca-cliente-dto';
import { RicercaContoCorrenteDto } from '../ricerca-conto-corrente-dto';

@Component({
  selector: 'app-associa-cc',
  templateUrl: './associa-cc.component.html',
  styleUrls: ['./associa-cc.component.css']
})
export class AssociaCcComponent implements OnInit {

  clienti: Cliente[] = [];
  cliente = new Cliente();
  contoCorrente = new ContoCorrente();
  contiCorrente: ContoCorrente[] = [];
  ricercaConto = "";
  ricercaCliente = "";
  constructor(private http: HttpClient) { }


  ngOnInit(): void {
  }

  cercaCliente() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    this.http.post<ListaClientiDto>("http://localhost:8080/ricerca-c", dto)
      .subscribe(r => this.clienti = r.listaClienti);
  }

  cercaContoCorrente() {
    let dto = new RicercaContoCorrenteDto();
    dto.codiceEsatto = this.ricercaConto;
    this.http.post<ListaContiCorrenteDto>("http://localhost:8080/ricerca-cc", dto)
      .subscribe(r => this.contiCorrente = r.listaContiCorrente);
  }
}

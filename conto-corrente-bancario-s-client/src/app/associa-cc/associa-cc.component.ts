import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { ListaContiCorrenteDto } from '../dto/lista-conti-corrente-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';
import { RicercaContoCorrenteDto } from '../dto/ricerca-conto-corrente-dto';

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

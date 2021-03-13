import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';

@Component({
  selector: 'app-mostra-tutti-i-conti',
  templateUrl: './mostra-tutti-i-conti.component.html',
  styleUrls: ['./mostra-tutti-i-conti.component.css']
})
export class MostraTuttiIContiComponent implements OnInit {
  clienti: Cliente[] = [];
  cliente = new Cliente();
  contoCorrente = new ContoCorrente();


  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    this.http.post<ListaClientiDto>("http://localhost:8080/mostra-tutti-i-conti", dto)
      .subscribe(r => this.clienti = r.listaClienti);
  }


  mostraConti() {
  }

}

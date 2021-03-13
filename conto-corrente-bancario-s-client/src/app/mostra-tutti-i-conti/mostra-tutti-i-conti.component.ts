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
  ricercaCliente: string;
  statoErroreCliente: string;
  erroreCliente: string;


  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    if (this.ricercaCliente == "") {
      this.statoErroreCliente = "e";
      console.log("Nessun criterio ricerca cliente inserito");
      this.erroreCliente = "Nessun criterio ricerca cliente inserito";
    } else {
      this.http.post<ListaClientiDto>("http://localhost:8080/ricerca-c", dto)
        .subscribe(r => this.clienti = r.listaClienti);
      this.statoErroreCliente = "";
      this.ricercaCliente = "";
    }}


  mostraConti() {
  }

}

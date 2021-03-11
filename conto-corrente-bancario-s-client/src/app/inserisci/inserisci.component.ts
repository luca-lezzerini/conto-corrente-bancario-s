import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteDto } from '../clienteDto';
import { ListaClientiDto } from '../listaClientiDto';

@Component({
  selector: 'app-inserisci',
  templateUrl: './inserisci.component.html',
  styleUrls: ['./inserisci.component.css']
})
export class InserisciComponent implements OnInit {

  cliente = new Cliente();
  clienti: Cliente[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  aggiungi() {

    //preparo i dati
    let dto = new ClienteDto;
    dto.cliente = this.cliente;
    //invio i dati al server
    let oss = this.http.post<ListaClientiDto>("http://localhost:8080/aggiungi", dto);
    oss.subscribe(c =>
      this.clienti = c.clienti
    );
    this.cliente = new Cliente();
  }

  nuovo(){}
}

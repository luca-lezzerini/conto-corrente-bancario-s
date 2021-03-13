import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteDto } from '../dto/cliente-dto';
import { ListaClientiDto } from '../dto/lista-clienti-dto';

@Component({
  selector: 'app-gestione-clienti',
  templateUrl: './gestione-clienti.component.html',
  styleUrls: ['./gestione-clienti.component.css']
})
export class GestioneClientiComponent implements OnInit {

  cliente = new Cliente();
  clienti: Cliente[] = [];
  stato = "Gestione-Cliente";
  gestoreBottoniTabella: Boolean[] = [];

  constructor(private http: HttpClient) {
    this.aggiorna();
    console.log(this.stato)
  }

  ngOnInit(): void {

  }

  aggiorna() {
    let oss = this.http.get<ListaClientiDto>("http://localhost:8080/aggiorna-cliente");
    oss.subscribe(c => {
      this.clienti = c.listaClienti
      this.inizializzaGestoreBottoniTabella(c.listaClienti);
    });
  }

  aggiungi() {

    //preparo i dati
    let dto = new ClienteDto();
    dto.cliente = this.cliente;
    //invio i dati al server
    let oss = this.http.post<ListaClientiDto>("http://localhost:8080/aggiungi", dto);
    oss.subscribe(c => {
      this.clienti = c.listaClienti
      this.inizializzaGestoreBottoniTabella(c.listaClienti);
    });
    this.cliente = new Cliente();
  }

  nuovo() { }

  modifica(c: Cliente, i: number) {
    let dto = new ClienteDto();
    dto.cliente = c;
    let oss = this.http.post<ClienteDto>("http://localhost:8080/modifica-cliente", dto);
    oss.subscribe(c => {
      this.cliente = c.cliente;
      this.stato = "modifica";
    });
  }

  cancella(c: Cliente) {
    this.stato = "cancella";
    console.log(c);
    this.cliente = c;
  }

  conferma() {
    switch (this.stato) {
      case "modifica":
        let dto = new ClienteDto();
        dto.cliente = this.cliente;

        this.http.post<ListaClientiDto>("http://localhost:8080/conferma-modifica-cliente", dto)
          .subscribe(c => {
            this.clienti = c.listaClienti
            this.cliente = new Cliente();
            this.stato = "Gestione-Cliente";
          });
        break;
      case "cancella":
        let dtoCanc = new ClienteDto();
        dtoCanc.cliente = this.cliente;

        this.http.post<ListaClientiDto>("http://localhost:8080/cancella", dtoCanc)
          .subscribe(c => {
            this.clienti = c.listaClienti;
            this.inizializzaGestoreBottoniTabella(c.listaClienti);
            this.stato = "Gestione-Cliente";
          });
        break;
      default:
        console.log("evento conferma inatteso")
        break;
    }
  }

  annulla() {
    this.cliente = new Cliente();
    this.stato = "Gestione-Cliente";
  }

  inizializzaGestoreBottoniTabella(listaClienti: Cliente[]) {
    for (let l of listaClienti) {
      this.gestoreBottoniTabella.push(false);
    }
  }
}

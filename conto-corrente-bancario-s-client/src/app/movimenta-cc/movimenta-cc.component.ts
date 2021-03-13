import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Data } from '@angular/router';
import { ContoCorrente } from '../conto-corrente';
import { ListaContiCorrenteDto } from '../dto/lista-conti-corrente-dto';
import { RicercaContoCorrenteDto } from '../dto/ricerca-conto-corrente-dto';

@Component({
  selector: 'app-movimenta-cc',
  templateUrl: './movimenta-cc.component.html',
  styleUrls: ['./movimenta-cc.component.css']
})
export class MovimentaCcComponent implements OnInit {

  CodiceConto = "";
  Importo = "";
  ContoSelezionato = "";
  contiCorrente: ContoCorrente[] = [];
  search = "";
  url = "http://localhost:8080/";
  ContoCorrente: ContoCorrente = new ContoCorrente();
  data: Data;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {

    /*let cercaConto = new RicercaContoCorrenteDto();
    cercaConto.codiceEsatto = this.search;

    let ox = this.http.post<ListaContiCorrenteDto>(this.url + "cerca-movimenta-cc",
      cercaConto
    );

    ox.subscribe(u => this.contiCorrente = u.listaContiCorrente);
    */

    let dto = new ContoCorrente();
    dto.numeroConto = this.CodiceConto;
    if (this.CodiceConto == "") {
      console.log("nessun conto selezionato");
    } else {
      if (this.CodiceConto == dto.numeroConto) {
        console.log("C'è l'elemento!");
      }
    }

  }

  esegui() {

  }

  seleziona() { }

}




import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
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
  contiCorrente: ContoCorrente[] = [];
  search = "";
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {

    let cercaConto = new RicercaContoCorrenteDto();
    cercaConto.codiceEsatto = this.search;

    let ox = this.http.post<ListaContiCorrenteDto>("http://localHost:8080/cerca-movimenta-cc",
      cercaConto
    );

    ox.subscribe(u => this.contiCorrente = u.listaContiCorrente);
  }

  esegui() { 
    
  }

  seleziona() { }

}




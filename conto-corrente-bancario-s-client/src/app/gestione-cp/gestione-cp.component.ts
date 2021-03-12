import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContoPrestito } from '../conto-prestito';
import { ContoPrestitoDto } from '../conto-prestito-dto';
import { ListaClientiDto } from '../lista-clienti-dto';
import { ListaContiPrestitoDto } from '../lista-conti-prestito-dto';

@Component({
  selector: 'app-gestione-cp',
  templateUrl: './gestione-cp.component.html',
  styleUrls: ['./gestione-cp.component.css']
})
export class GestioneCpComponent implements OnInit {
  contoPrestito: ContoPrestito = new ContoPrestito();
  showFormChoice: boolean = false;
  showFormTable: boolean = false;
  showAdd: boolean = true;
  codici: ContoPrestito[] = [];
  rigaCorrente: number;
  url = "http://localhost:8080/";

  constructor(private router: Router, private http: HttpClient) {
    this.aggiorna();
    this.showFormTable = true;
  }

  ngOnInit(): void {
  }

  new() {

  }

  add() {
    let dto = new ContoPrestitoDto();
    dto.contoPrestito = this.contoPrestito;
    this.http.post<ListaContiPrestitoDto>(this.url + "aggiungi-cp", dto)
      .subscribe(r => this.codici = r.listaContiPrestito);
    this.showFormTable = true;
  }

  aggiorna() {
    this.http.get<ListaContiPrestitoDto>(this.url + "aggiorna-cp")
      .subscribe(r => this.codici = r.listaContiPrestito);
    this.showFormTable = true;
  }

  edit(c: ContoPrestito, i: number) {
    let dto = new ContoPrestitoDto();
    dto.contoPrestito = c;
    this.http.post<ContoPrestitoDto>("http://localhost:8080/modifica-cp", dto)
      .subscribe(r => this.contoPrestito = r.contoPrestito);
    this.showFormChoice = true;
    this.showAdd = false;
    this.showFormTable = false;
    this.contoPrestito = Object.assign({}, this.codici[i]);
    this.rigaCorrente = i;


  }
  delete(c: ContoPrestito) {
    let dto = new ContoPrestitoDto();
    dto.contoPrestito = c;
    this.http.post<ListaContiPrestitoDto>("http://localhost:8080/elimina-cp", dto)
      .subscribe(r => this.codici = r.listaContiPrestito);
    this.showFormTable = true;
  }

  conferma() {

  }

  annulla() {

  }

}

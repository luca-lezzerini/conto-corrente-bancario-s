import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContoPrestito } from '../conto-prestito';
import { ContoPrestitoDto } from '../dto/conto-prestito-dto';
import { ListaContiPrestitoDto } from '../dto/lista-conti-prestito-dto';

@Component({
  selector: 'app-gestione-cp',
  templateUrl: './gestione-cp.component.html',
  styleUrls: ['./gestione-cp.component.css']
})
export class GestioneCpComponent implements OnInit {
  contoPrestito: ContoPrestito = new ContoPrestito();

  codici: ContoPrestito[] = [];
  url = "http://localhost:8080/";

  stato ="new";

  constructor(private router: Router, private http: HttpClient) {
    this.aggiorna();
  }

  ngOnInit(): void {
  }

  new() {
    this.stato="add";
    this.contoPrestito = new ContoPrestito();

  }

  add() {
    let dto = new ContoPrestitoDto();
    dto.contoPrestito = this.contoPrestito;
    this.http.post<ListaContiPrestitoDto>(this.url + "aggiungi-cp", dto)
      .subscribe(r => this.codici = r.listaContiPrestito);
  }

  aggiorna() {
    this.http.get<ListaContiPrestitoDto>(this.url + "aggiorna-cp")
      .subscribe(r => this.codici = r.listaContiPrestito);
  }

  edit(c: ContoPrestito, i: number) {
    let dto = new ContoPrestitoDto();
    dto.contoPrestito = c;
    this.http.post<ContoPrestitoDto>("http://localhost:8080/modifica-cp", dto)
      .subscribe(r => this.contoPrestito = r.contoPrestito);
    this.contoPrestito = Object.assign({}, this.codici[i]);
    this.stato="edit";
  }
  delete(c: ContoPrestito) {
    let dto = new ContoPrestitoDto();
    dto.contoPrestito = c;
    this.http.post<ListaContiPrestitoDto>("http://localhost:8080/elimina-cp", dto)
      .subscribe(r => this.codici = r.listaContiPrestito);
  
  }

  conferma() {

  }

  annulla() {
    this.stato="add";

  }

}

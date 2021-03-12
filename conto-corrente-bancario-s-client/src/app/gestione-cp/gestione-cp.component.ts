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
  codici: ContoPrestito[] = [];
  url = "http://localhost:8080/";

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
  }

  new() {

  }

  add() {
    let dto = new ContoPrestitoDto();
    dto.contoPrestito = this.contoPrestito;
    this.http.post<ListaContiPrestitoDto>(this.url + "aggiungi", dto)
      .subscribe(r => this.codici = r.listaContiPrestito);
  }
  edit() {
    this.showFormChoice = true;
  }
  delete() {

  }



}

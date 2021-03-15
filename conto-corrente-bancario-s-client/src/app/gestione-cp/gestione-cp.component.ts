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
  errore = "";
  codici: ContoPrestito[] = [];
  url = "http://localhost:8080/";

  stato = "new";

  constructor(private router: Router, private http: HttpClient) {
    this.aggiorna();
  }

  ngOnInit(): void {
  }

  new() {
    this.stato = "add";
    this.contoPrestito = new ContoPrestito();

  }

  add() {
    if (this.contoPrestito.codice == "") {
      this.errore = "Errore! devi inserire un codice."
    } else {
      let dto = new ContoPrestitoDto();
      dto.contoPrestito = this.contoPrestito;
      this.http.post<ListaContiPrestitoDto>(this.url + "aggiungi-cp", dto)
        .subscribe(r => this.codici = r.listaContiPrestito);
      this.contoPrestito = new ContoPrestito();
    }
  }

  aggiorna() {
    this.http.get<ListaContiPrestitoDto>(this.url + "aggiorna-cp")
      .subscribe(r => {
        this.codici = r.listaContiPrestito;
        if (this.codici.length == 0) {
          this.stato = "new";
        } else {
          this.stato = "add";
        }
      });
  }

  edit(c: ContoPrestito, i: number) {
    let dto = new ContoPrestitoDto();
    dto.contoPrestito = c;
    this.http.post<ContoPrestitoDto>("http://localhost:8080/modifica-cp", dto)
      .subscribe(r => this.contoPrestito = r.contoPrestito);
    this.contoPrestito = Object.assign({}, this.codici[i]);
    this.stato = "edit";
  }
  delete(c: ContoPrestito) {
    this.stato = "delete";
    this.contoPrestito = c;

  }

  conferma() {
    switch (this.stato) {
      case "edit":
        let dto = new ContoPrestitoDto();
        dto.contoPrestito = this.contoPrestito;
        this.http.post<ListaContiPrestitoDto>(this.url + "conferma-cp", dto)
          .subscribe(r => {
            this.codici = r.listaContiPrestito;
            this.contoPrestito = new ContoPrestito;
            this.stato = "add";
          });
        break;
      case "delete":
        let dtoCanc = new ContoPrestitoDto();
        dtoCanc.contoPrestito = this.contoPrestito;
        this.http.post<ListaContiPrestitoDto>("http://localhost:8080/elimina-cp", dtoCanc)
          .subscribe(r => {
            this.codici = r.listaContiPrestito
            this.contoPrestito = new ContoPrestito();
            if (this.codici.length == 0) {
              this.stato = "new";
            } else {
              this.stato = "add";
            }
          });
        break;
      default:
        console.log("evento conferma inatteso")
        break;
    }
  }

  annulla() {
    this.contoPrestito = new ContoPrestito();
    this.stato = "add";

  }

}

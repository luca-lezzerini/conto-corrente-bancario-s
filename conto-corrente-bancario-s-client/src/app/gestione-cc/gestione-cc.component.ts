import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContoCorrente } from '../conto-corrente';
import { ContoCorrenteDto } from '../dto/conto-corrente-dto';
import { ListaContiCorrenteDto } from '../dto/lista-conti-corrente-dto';

@Component({
  selector: 'app-gestione-cc',
  templateUrl: './gestione-cc.component.html',
  styleUrls: ['./gestione-cc.component.css']
})
export class GestioneCcComponent implements OnInit {
  contoCorrente = new ContoCorrente();
  contiCorrente: ContoCorrente[] = [];
  stato = "new";
  errore = "";
  constructor(private route: Router, private http: HttpClient) {
    this.aggiorna();

  }

  ngOnInit(): void {
  }

  new() {
    this.stato = "add";
  }

  aggiungi() {
    let dto = new ContoCorrenteDto();
    dto.contoCorrente = this.contoCorrente;
    if (this.contoCorrente.numeroConto == "") {
      this.errore = "E' necessario inserire un codice valido prima di cliccare add"
    } else if (this.contoCorrente.numeroConto == " ") {
      this.errore = "Iniziare con uno spazio non è consentito"
    } else {
      this.errore = "";
      this.http.post<ListaContiCorrenteDto>("http://localhost:8080/aggiungi-cc", dto)
        .subscribe(r => {
          this.contiCorrente = r.listaContiCorrente
        });
      this.contoCorrente = new ContoCorrente();
      this.stato = "new";
    }
  }

  elimina(n: ContoCorrente) {
    this.contoCorrente = n;
    this.stato = "delete";
  }

  modifica(n: ContoCorrente) {
    let dto = new ContoCorrenteDto();
    dto.contoCorrente = n;
    this.http.post<ContoCorrenteDto>("http://localhost:8080/modifica-cc", dto)
      .subscribe(r => this.contoCorrente = r.contoCorrente);
    this.stato = "edit";
  }

  conferma() {
    switch (this.stato) {
      case "edit":
        let dto = new ContoCorrenteDto();
        dto.contoCorrente = this.contoCorrente;
        this.http.post<ListaContiCorrenteDto>("http://localhost:8080/conferma-cc", dto)
          .subscribe(r => this.contiCorrente = r.listaContiCorrente);
        this.contoCorrente = new ContoCorrente();
        this.stato = "add";
        break;
      case "delete":
        let dtoC = new ContoCorrenteDto();
        dtoC.contoCorrente = this.contoCorrente;
        this.http.post<ListaContiCorrenteDto>("http://localhost:8080/elimina-cc", dtoC)
          .subscribe(r => this.contiCorrente = r.listaContiCorrente);
        this.contoCorrente = new ContoCorrente();
        this.stato = "add";
        break;
    }
  }

  annulla() {
    this.contoCorrente = new ContoCorrente();
    this.stato = "add";
  }

  aggiorna() {
    this.http.get<ListaContiCorrenteDto>("http://localhost:8080/aggiorna-cc")
      .subscribe(r => this.contiCorrente = r.listaContiCorrente);
  }


}

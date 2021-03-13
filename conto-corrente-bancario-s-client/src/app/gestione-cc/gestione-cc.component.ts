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

  constructor(private route: Router, private http: HttpClient) { }
  showForm = false;
  showNew = true;
  showTable = false;
  showEdit = false;
  showAdd = false;
  ngOnInit(): void {
  }

  new() {
    this.showForm = true;
    this.showNew = false;
    this.showTable = true;
    this.showAdd = true;
  }

  aggiungi() {
    let dto = new ContoCorrenteDto();
    dto.contoCorrente = this.contoCorrente;
    this.http.post<ListaContiCorrenteDto>("http://localhost:8080/aggiungi-cc", dto)
      .subscribe(r => this.contiCorrente = r.listaContiCorrente);
    this.contoCorrente = new ContoCorrente();
    this.showForm = false;
    this.showNew = true;
    this.showTable = false;
  }

  elimina(n: ContoCorrente) {
    let dto = new ContoCorrenteDto();
    dto.contoCorrente = n;
    this.http.post<ListaContiCorrenteDto>("http://localhost:8080/elimina-cc", dto)
      .subscribe(r => this.contiCorrente = r.listaContiCorrente);
  }

  modifica(n: ContoCorrente) {
    let dto = new ContoCorrenteDto();
    dto.contoCorrente = n;
    this.http.post<ContoCorrenteDto>("http://localhost:8080/modifica-cc", dto)
      .subscribe(r => this.contoCorrente = r.contoCorrente);
      this.showEdit = true;
      this.showAdd = false;
  }

  conferma() {
    let dto = new ContoCorrenteDto();
    dto.contoCorrente = this.contoCorrente;
    this.http.post<ListaContiCorrenteDto>("http://localhost:8080/conferma-cc", dto)
    .subscribe(r => this.contiCorrente = r.listaContiCorrente);
    this.showAdd = true;
    this.showTable = true;
    this.showEdit = false;
    this.contoCorrente = new ContoCorrente();
  }

  annulla() {
    this.contoCorrente = new ContoCorrente();
    this.showEdit = false;
    this.showAdd = true;
  }


}

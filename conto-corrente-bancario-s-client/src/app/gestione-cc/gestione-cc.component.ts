import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContoCorrente } from '../conto-corrente';
import { ContoCorrenteDto } from '../conto-corrente-dto';
import { ListaContiCorrenteDto } from '../lista-conti-corrente-dto';

@Component({
  selector: 'app-gestione-cc',
  templateUrl: './gestione-cc.component.html',
  styleUrls: ['./gestione-cc.component.css']
})
export class GestioneCcComponent implements OnInit {
  contoCorrente = new ContoCorrente();
  contiCorrente: ContoCorrente[] = [];

  constructor(private route: Router, private http: HttpClient) { }
  // showForm = false;
  ngOnInit(): void {
  }

  new() {
    // this.showForm = true;
  }

  aggiungi() {
    let dto = new ContoCorrenteDto();
    dto.contoCorrente = this.contoCorrente;
    this.http.post<ListaContiCorrenteDto>("http://localhost:8080/aggiungi-cc", dto)
      .subscribe(r => this.contiCorrente = r.listaContiCorrente);
    this.contoCorrente = new ContoCorrente();
  }
}

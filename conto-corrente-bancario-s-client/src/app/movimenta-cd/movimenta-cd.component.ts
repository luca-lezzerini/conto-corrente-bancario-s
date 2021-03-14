import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ContoCorrente } from '../conto-corrente';
import { RicercaContoCorrenteDto } from '../dto/ricerca-conto-corrente-dto';
import { TuttiContiDto } from '../dto/tutti-conti-dto';

@Component({
  selector: 'app-movimenta-cd',
  templateUrl: './movimenta-cd.component.html',
  styleUrls: ['./movimenta-cd.component.css']
})
export class MovimentaCdComponent implements OnInit {
  codiceConto = "";
  contiCorrente: ContoCorrente[] = [];
  ContoSelezionato="";
  importo:number;
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }
  cerca() {
    let ric = new RicercaContoCorrenteDto();
    ric.codiceEsatto = this.codiceConto;
    this.http.post<TuttiContiDto>("http://localhost:8080/ricerca", ric)
      .subscribe(r => {
        this.contiCorrente = r.contiCorrenti;
      });
  }

  esegui() { }
}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ContoDeposito } from '../conto-deposito';
import { ListaMovimentiCdDto } from '../dto/lista-movimenti-cd-dto';
import { MovimentoCdDto } from '../dto/movimento-cd-dto';
import { RicercaContoCorrenteDto } from '../dto/ricerca-conto-corrente-dto';
import { RitMovimentiCdDto } from '../dto/rit-movimenti-cd-dto';
import { MovimentiContoDeposito } from '../movimenti-cd';

@Component({
  selector: 'app-movimenta-cd',
  templateUrl: './movimenta-cd.component.html',
  styleUrls: ['./movimenta-cd.component.css']
})
export class MovimentaCdComponent implements OnInit {

  contoDeposito = new ContoDeposito();
  contoSelezionato = "";
  importo = 0;
  erroreConto = "";
  movimentoCd = new MovimentiContoDeposito();
  movimentiCd: MovimentiContoDeposito[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void { }
  cerca() {
    this.contoSelezionato = "";
    let ric = new RicercaContoCorrenteDto();
    ric.codiceEsatto = this.contoDeposito.codice;
    if (this.contoDeposito.codice == "") {
      console.log("Nessun conto selezionato");
      this.erroreConto = "Nessun conto selezionato";
    } else {
      this.erroreConto = "";
      this.http.post<RitMovimentiCdDto>("http://localhost:8080/cd-ricerca", ric)
        .subscribe(r => {
          if (r.contoDeposito == null) {
            this.erroreConto = "Nessun conto trovato";
          } else {
            this.erroreConto = "";
            this.contoSelezionato = r.contoDeposito.codice;
            this.contoDeposito = r.contoDeposito;
            this.movimentiCd = r.movimentiContoDeposito;
          }
        });
      this.contoDeposito = new ContoDeposito();
    }
  }
  esegui() {
    let dto = new MovimentoCdDto();
    dto.movimentoCd = this.movimentoCd;
    dto.contoDeposito = this.contoDeposito;
    this.http.post<ListaMovimentiCdDto>("http://localhost:8080/salva-movimento-cd", dto)
      .subscribe(r => {
        this.movimentiCd = r.listaMovimentiCd;
      });
  }
}
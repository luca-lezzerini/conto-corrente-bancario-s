import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Data } from '@angular/router';
import { ContoCorrente } from '../conto-corrente';
import { ContoCorrenteDto } from '../dto/conto-corrente-dto';
import { ListaContiCorrenteDto } from '../dto/lista-conti-corrente-dto';
import { ListaMovimentiCcDto } from '../dto/lista-movimenti-cc-dto';
import { MovimentoCcDto } from '../dto/movimento-cc-dto';
import { RicercaContoCorrenteDto } from '../dto/ricerca-conto-corrente-dto';
import { MovimentiContoCorrente } from '../movimenti-conto-corrente';

@Component({
  selector: 'app-movimenta-cc',
  templateUrl: './movimenta-cc.component.html',
  styleUrls: ['./movimenta-cc.component.css', '../app.component.css']
})
export class MovimentaCcComponent implements OnInit {
  
  codiceConto = "";
  importo = "";
  contoSelezionato = "";
  contiCorrente: ContoCorrente[] = [];
  search = "";
  url = "http://localhost:8080/";
  data: Data;
  contoDaCercare = new ContoCorrente();
  erroreCliente = "";
  erroreConto = "";
  statoErroreCliente = "";
  statoErroreConto = "";
  movimento = new MovimentiContoCorrente();
  listaMovimentiCc: MovimentiContoCorrente[] = []; //genero un array che nel momento in cui con la lambda mi arriva la risposta,inserisco i pezzi della risposta qui dentro per poterli poi visualizzare
  //CodiceConto = new ContoCorrente();
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {
    let dto = new RicercaContoCorrenteDto();
    dto.codiceEsatto = this.codiceConto;

    if (this.codiceConto == "") { //controllo che il campo di ricerca è vuoto
      this.statoErroreConto = "e"; //passo nello stato di errore
      console.log("Nessun conto selezionato");  //scrivo il messaggio che deve apparire
      this.erroreConto = "Nessun conto selezionato";
    } else {
      this.erroreConto = "";
      this.http.post<ContoCorrenteDto>(this.url + "ricerca-cc", dto)
        .subscribe(r => this.contoDaCercare = r.contoCorrente
        ); //in caso non sia vuoto,assegno il risultato della ricerca alla label dove compare 
      //il codice del conto selezionato che ho cercato

    }

  }

  esegui() {
    //preparo i dati che devo mandare al server
    let dto = new MovimentoCcDto(); //gli passo il movimento
    dto.movimentoCc = this.movimento; //gli mando il movimento 
    dto.contoCorrente = this.contoDaCercare; //e il conto da cercare,mandandoli nel dto
    this.http.post<ListaMovimentiCcDto>(this.url + "salva-movimento-cc", dto)
      .subscribe(u => this.listaMovimentiCc = u.listaMovimentiCc);
  }

  seleziona() { }

}




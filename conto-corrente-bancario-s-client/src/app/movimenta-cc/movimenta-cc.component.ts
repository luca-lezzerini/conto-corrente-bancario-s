import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Data } from '@angular/router';
import { ContoCorrente } from '../conto-corrente';
import { ContoCorrenteDto } from '../dto/conto-corrente-dto';
import { ListaContiCorrenteDto } from '../dto/lista-conti-corrente-dto';
import { ListaMovimentiCcDto } from '../dto/lista-movimenti-cc-dto';
import { RicercaContoCorrenteDto } from '../dto/ricerca-conto-corrente-dto';
import { MovimentaCcDto } from './movimenta-cc-dto';
import { Mov } from './mov';

@Component({
  selector: 'app-movimenta-cc',
  templateUrl: './movimenta-cc.component.html',
  styleUrls: ['./movimenta-cc.component.css']
})
export class MovimentaCcComponent implements OnInit {
  tipoMovimento = "V";
  codiceConto = "";
  importo = "";
  contoSelezionato = "";
  contiCorrente: ContoCorrente[] = [];
  search = "";
  url = "http://localhost:8080/";
  data: Data;
  contoCorrente = new ContoCorrente();
  erroreCliente = "";
  erroreConto = "";
  statoErroreCliente = "";
  statoErroreConto = "";
  //CodiceConto = new ContoCorrente();
  movimento = new MovimentaCcDto();
  mov:MovimentaCcDto[] = [];
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
        .subscribe(r => this.contoSelezionato = r.contoCorrente.numeroConto
        ); //in caso non sia vuoto,assegno il risultato della ricerca alla label dove compare 
      //il codice del conto selezionato che ho cercato

    }

  }

  esegui() {
    let dto = new MovimentaCcDto();
    dto.MovimentaCc = this.movimento;

    let ox = this.http.post<ListaMovimentiCcDto>(
      this.url + "inserisci-movimento", dto
    );
    ox.subscribe(s => this.mov = s.listaMovimentiCc );

    this.movimento = new MovimentaCcDto();
    /*
    let dto = new MovimentoCpDto();
    dto.movimentoCp = this.movimentoCp;
    dto.contoPrestito = this.contoDaCercare;
    let oss = this.http.post<ListaMovimentiCpDto>("http://localhost:8080/salva-movimento-cp",dto)
    oss.subscribe(c =>{
      this.listaMovimentiCp = c.listaMovimentiCp;
    });
  }
    */
  }

  seleziona() { }

}




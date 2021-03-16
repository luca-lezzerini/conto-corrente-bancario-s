import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ContoPrestito } from '../conto-prestito';
import { ContoPrestitoDto } from '../dto/conto-prestito-dto';
import { ListaMovimentiCpDto } from '../dto/lista-movimenti-cp-dto';
import { MovimentiAssCpDto } from '../dto/movimenti-ass-cp-dto';
import { MovimentoCpDto } from '../dto/movimento-cp-dto';
import { RicercaContoCorrenteDto } from '../dto/ricerca-conto-corrente-dto';
import { MovimentiContoPrestito } from '../movimenti-cp';

@Component({
  selector: 'app-movimenta-cp',
  templateUrl: './movimenta-cp.component.html',
  styleUrls: ['./movimenta-cp.component.css']
})
export class MovimentaCpComponent implements OnInit {

  contoDaCercare = new ContoPrestito();
  contoSelezionato = "";

  movimentoCp = new MovimentiContoPrestito();
  listaMovimentiCp: MovimentiContoPrestito[] = [];  

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {
    let dto = new RicercaContoCorrenteDto();
    dto.codiceEsatto = this.contoDaCercare.codice;
    let oss = this.http.post<MovimentiAssCpDto>("http://localhost:8080/cerca-cp", dto);
    oss.subscribe(c => {
      this.contoDaCercare = c.contoPrestito;
      this.contoSelezionato = c.contoPrestito.codice;
      this.listaMovimentiCp = c.movimentiContoPrestito;
    });
    this.contoDaCercare = new ContoPrestito();
  }

  esegui() {
    let dto = new MovimentoCpDto();
    dto.movimentoCp = this.movimentoCp;
    dto.contoPrestito = this.contoDaCercare;
    this.http.post<ListaMovimentiCpDto>("http://localhost:8080/salva-movimento-cp", dto)
      .subscribe(c => {
        this.listaMovimentiCp = c.listaMovimentiCp;
      });
  }

}

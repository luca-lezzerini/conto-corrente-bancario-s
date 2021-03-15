import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ContoPrestito } from '../conto-prestito';
import { ListaMovimentiCpDto } from '../dto/lista-movimenti-cp-dto';
import { MovimentoCpDto } from '../dto/movimento-cp-dto';
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

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  cerca(){
    let dto = new ContoPrestito();
    dto.codice = this.contoDaCercare.codice;
    let oss = this.http.post<ContoPrestito>("http://localhost:8080/cerca-cp",dto);
    oss.subscribe(c =>{
      this.contoDaCercare = c;
      this.contoSelezionato = c.codice;
    });
    this.contoDaCercare = new ContoPrestito();
  }

  esegui(){
    let dto = new MovimentoCpDto();
    dto.movimentoCp = this.movimentoCp;

    let oss = this.http.post<ListaMovimentiCpDto>("http://localhost:8080/salva-movimento-cp",dto)
    oss.subscribe(c =>{
      this.listaMovimentiCp = c.listaMovimentiCp;
    });
  }

}

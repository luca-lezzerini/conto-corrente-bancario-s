import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';
import { MovimentiContoCorrente } from '../movimenti-conto-corrente';

@Component({
  selector: 'app-estratto-conto-cc',
  templateUrl: './estratto-conto-cc.component.html',
  styleUrls: ['./estratto-conto-cc.component.css','../app.component.css']
})
export class EstrattoContoCcComponent implements OnInit {
  ricercaCliente = "";
  clienti: Cliente[] = [];
  contiCorrente: ContoCorrente[] = [];
  movimentiCC : MovimentiContoCorrente[] = [];
  constructor(private http : HttpClient) { }

  ngOnInit(): void {
  }

  cercaCliente() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    this.http.post<ListaClientiDto>("http://localhost:8080/ricerca-cliente-e-c-cc", dto)
      .subscribe(r => this.clienti = r.listaClienti);
  


  }
  seleziona() {

  }
  estrattoConto() {

  }
}

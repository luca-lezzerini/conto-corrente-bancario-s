import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { ClienteDto } from '../dto/cliente-dto';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { ListaContiCorrenteDto } from '../dto/lista-conti-corrente-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';
import { TuttiContiDto } from '../dto/tutti-conti-dto';
import { MovimentiContoCorrente } from '../movimenti-conto-corrente';

@Component({
  selector: 'app-estratto-conto-cc',
  templateUrl: './estratto-conto-cc.component.html',
  styleUrls: ['./estratto-conto-cc.component.css', '../app.component.css']
})
export class EstrattoContoCcComponent implements OnInit {
  ricercaCliente = "";
  clienti: Cliente[] = [];
  contiCorrente: ContoCorrente[] = [];
  movimentiCC: MovimentiContoCorrente[] = [];
  url = "http://localhost:8080/";
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cercaCliente() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    this.http.post<ListaClientiDto>(this.url + "ricerca-cliente-e-c-cc", dto)
      .subscribe(r => this.clienti = r.listaClienti);



  }
  seleziona(c: Cliente) {
    let dto = new ClienteDto();
    dto.cliente = c;
    this.http.post<ListaContiCorrenteDto>(this.url + "seleziona-e-c-cc", dto)
      .subscribe(r => this.contiCorrente = r.listaContiCorrente);

  }
  estrattoConto() {

  }
}

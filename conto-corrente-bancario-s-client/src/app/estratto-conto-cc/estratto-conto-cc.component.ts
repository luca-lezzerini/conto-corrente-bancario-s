import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { ClienteDto } from '../dto/cliente-dto';
import { ContoCorrenteDto } from '../dto/conto-corrente-dto';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { ListaMovimentiCcDto } from '../dto/lista-movimenti-cc-dto';
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
  erroreRicerca = "";
  stato = "ricerca";
  clienti: Cliente[] = [];
  contiCorrente: ContoCorrente[] = [];
  movimentiCC: MovimentiContoCorrente[] = [];
  contoSelezionato = "";
  url = "http://localhost:8080/";

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cercaCliente() {
    if (this.ricercaCliente == "") {
      console.log(this.erroreRicerca = "Errore! è necessario inserire un cliente.");
    } else {
      let dto = new RicercaClienteDto();
      dto.ricercaPerCognome = this.ricercaCliente;
      this.http.post<ListaClientiDto>(this.url + "ricerca-cliente-e-c-cc", dto)
        .subscribe(r => {
          this.clienti = r.listaClienti;
          this.ricercaCliente = "";
        });
    }
    this.stato = "clienti";
  }
  seleziona(c: Cliente) {
    let dto = new ClienteDto();
    dto.cliente = c;
    this.http.post<TuttiContiDto>(this.url + "seleziona-e-c-cc", dto)
      .subscribe(r => this.contiCorrente = r.contiCorrenti);
    this.stato = "conti";

  }
  estrattoConto(cc: ContoCorrente) {
    this.contoSelezionato = cc.numeroConto;
    let dto = new ContoCorrenteDto();
    dto.contoCorrente = cc;
    this.http.post<ListaMovimentiCcDto>(this.url + "estratto-conto-cc", dto)
      .subscribe(r => this.movimentiCC = r.listaMovimentiCc);
    this.stato = "estrattoConto";
  }
}

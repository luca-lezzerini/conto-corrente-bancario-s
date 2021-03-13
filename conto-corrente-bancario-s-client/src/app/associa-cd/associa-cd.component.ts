import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoDeposito } from '../conto-deposito';
import { AssociaCdDto } from '../dto/associa-cd-dto';
import { ContoDepositoDto } from '../dto/conto-deposito-dto';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';
import { RicercaContoCorrenteDto } from '../dto/ricerca-conto-corrente-dto';

@Component({
  selector: 'app-associa-cd',
  templateUrl: './associa-cd.component.html',
  styleUrls: ['./associa-cd.component.css']
})
export class AssociaCdComponent implements OnInit {

  clienti: Cliente[] = [];
  cliente = new Cliente();
  contoDeposito = new ContoDeposito();
  ricercaConto = "";
  ricercaCliente = "";
  cdTrovato = "";

  constructor(private http: HttpClient) { }


  ngOnInit(): void {
  }

  cercaCliente() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    this.http.post<ListaClientiDto>("http://localhost:8080/ricerca-c", dto)
      .subscribe(r => this.clienti = r.listaClienti);
  }

  cercaContoDeposito() {
    let dto = new RicercaContoCorrenteDto();
    dto.codiceEsatto = this.ricercaConto;
    this.http.post<ContoDepositoDto>("http://localhost:8080/ricerca-cd", dto)
      .subscribe(r => {
        if (r.contoDeposito != null) {
          this.cdTrovato = r.contoDeposito.codice;
          this.contoDeposito = r.contoDeposito;
        }else console.log("nessun Conto deposito corrispondente al criterio di ricerca")
      });
  }

  associa(c: Cliente) {
    let assDto = new AssociaCdDto();
    assDto.cliente = c;
    assDto.contoDeposito = this.contoDeposito;
    if (this.contoDeposito.id == null) {
      console.log("nessun conto selezionato")
    } else {
      this.http.post<String>("http://localhost:8080/associa-cd", assDto)
        .subscribe(m => console.log(m));
    }
  }

}

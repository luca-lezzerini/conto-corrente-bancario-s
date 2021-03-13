import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoPrestito } from '../conto-prestito';
import { AssociaCpDto } from '../dto/associa-cp-dto';
import { ContoDepositoDto } from '../dto/conto-deposito-dto';
import { ContoPrestitoDto } from '../dto/conto-prestito-dto';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';
import { RicercaContoCorrenteDto } from '../dto/ricerca-conto-corrente-dto';

@Component({
  selector: 'app-associa-cp',
  templateUrl: './associa-cp.component.html',
  styleUrls: ['./associa-cp.component.css']
})
export class AssociaCpComponent implements OnInit {
  clienti: Cliente[] = [];
  cliente = new Cliente();
  contoPrestito = new ContoPrestito();
  ricercaConto = "";
  ricercaCliente = "";
  cpTrovato = "";

  constructor(private http: HttpClient) { }


  ngOnInit(): void {
  }

  cercaCliente() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    this.http.post<ListaClientiDto>("http://localhost:8080/ricerca-c", dto)
      .subscribe(r => this.clienti = r.listaClienti);
  }

  cercaContoPrestito() {
    let dto = new RicercaContoCorrenteDto();
    dto.codiceEsatto = this.ricercaConto;
    this.http.post<ContoPrestitoDto>("http://localhost:8080/ricerca-cp", dto)
      .subscribe(r => {
        if (r.contoPrestito != null) {
          this.cpTrovato = r.contoPrestito.codice;
          this.contoPrestito = r.contoPrestito;
        }else console.log("nessun Conto prestito corrispondente al criterio di ricerca")
      });
  }

  associa(c: Cliente) {
    let assDto = new AssociaCpDto();
    assDto.cliente = c;
    assDto.contoPrestito = this.contoPrestito;
    if (this.contoPrestito.id == null) {
      console.log("nessun conto selezionato")
    } else {
      this.http.post<String>("http://localhost:8080/associa-cp", assDto)
        .subscribe(m => console.log(m));
    }
  }

}

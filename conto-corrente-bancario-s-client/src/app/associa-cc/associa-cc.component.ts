import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { AssociaCcDto } from '../dto/associa-cc-dto';
import { ContoCorrenteDto } from '../dto/conto-corrente-dto';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';
import { RicercaContoCorrenteDto } from '../dto/ricerca-conto-corrente-dto';

@Component({
  selector: 'app-associa-cc',
  templateUrl: './associa-cc.component.html',
  styleUrls: ['./associa-cc.component.css']
})
export class AssociaCcComponent implements OnInit {

  clienti: Cliente[] = [];
  cliente = new Cliente();
  contoCorrente = new ContoCorrente();
  ricercaConto = "";
  ricercaCliente = "";
  contoTrovato = "";
  erroreCliente = "";
  erroreConto = "";
  statoErroreCliente = "";
  statoErroreConto = "";
  constructor(private http: HttpClient) { }


  ngOnInit(): void {
  }

  cercaCliente() {
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome = this.ricercaCliente;
    if (this.ricercaCliente == "") {
      this.statoErroreCliente = "e";
      console.log("Nessun criterio ricerca cliente inserito");
      this.erroreCliente = "Nessun criterio ricerca cliente inserito";
    } else {
      this.http.post<ListaClientiDto>("http://localhost:8080/ricerca-c", dto)
        .subscribe(r => this.clienti = r.listaClienti);
      this.statoErroreCliente = "";
    }
  }

  cercaContoCorrente() {
    let dto = new RicercaContoCorrenteDto();
    dto.codiceEsatto = this.ricercaConto;
    if (this.ricercaConto == "") {
      this.statoErroreConto = "e";
      console.log("Nessun criterio ricerca conto inserito");
      this.erroreConto = "Nessun criterio ricerca conto inserito";
    } else {
      this.http.post<ContoCorrenteDto>("http://localhost:8080/ricerca-cc", dto)
        .subscribe(r => {
          if (r.contoCorrente != null) {
            this.contoTrovato = r.contoCorrente.numeroConto;
            this.contoCorrente = r.contoCorrente;
            this.statoErroreConto = "";
          }
          else console.log("Nessun conto trovato");
          this.erroreConto = "Nessun conto trovato";
        });
    }
  }

  associa(c: Cliente) {
    let dto = new AssociaCcDto();
    dto.contoCorrente = this.contoCorrente;
    dto.cliente = c;
    if (this.contoCorrente.id == null) {
      console.log("Nessun conto da associare");
    } else {
      this.http.post<ContoCorrenteDto>("http://localhost:8080/associa-cc", dto)
        .subscribe(r => console.log(r));
    }
  }
}

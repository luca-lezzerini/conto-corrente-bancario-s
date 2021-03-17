import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ContoCorrente } from '../conto-corrente';
import { ListaClientiDto } from '../dto/lista-clienti-dto';
import { ListaMovimentiTotaliDto } from '../dto/lista-movimenti-totali-dto';
import { RicercaClienteDto } from '../dto/ricerca-cliente-dto';
import { RicercaContoCorrenteDto } from '../dto/ricerca-conto-corrente-dto';
import { TuttiIMovimenti } from '../tutti-i-movimenti';

@Component({
  selector: 'app-mostra-tutti-i-conti',
  templateUrl: './mostra-tutti-i-conti.component.html',
  styleUrls: ['./mostra-tutti-i-conti.component.css',
    '../app.component.css']
})
export class MostraTuttiIContiComponent implements OnInit {
  clienti: Cliente[] = [];
  cliente = new Cliente();
  contoCorrenteDaMostrare = new ContoCorrente();
  ricercaCliente = "";
  url = "http://localhost:8080/";
  statoErroreCliente = "";
  erroreCliente = "";
  numeroConto="";
  movimenti: TuttiIMovimenti[]=[];
 

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() {
    
    let dto = new RicercaClienteDto();
    dto.ricercaPerCognome= this.ricercaCliente;

    this.http.post<ListaClientiDto>(this.url + "ricerca-cliente-like", dto)
    .subscribe(t=>this.clienti = t.listaClienti);
    
  }

  mostraConti() {
  }

}

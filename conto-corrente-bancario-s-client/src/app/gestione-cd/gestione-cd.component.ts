import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ContoDeposito } from '../conto-deposito';
import { ContoDepositoDto } from '../dto/conto-deposito-dto';
import { ListaContiDepositoDto } from '../dto/lista-conti-deposito-dto';

@Component({
  selector: 'app-gestione-cd',
  templateUrl: './gestione-cd.component.html',
  styleUrls: ['./gestione-cd.component.css']
})
export class GestioneCdComponent implements OnInit {

  contoDeposito = new ContoDeposito();
  contiDepositi: ContoDeposito[] = [];

  constructor(private http: HttpClient) { 
    this.aggiorna();
  }

  ngOnInit(): void {
  }

  aggiorna(){
    let oss = this.http.get<ListaContiDepositoDto>("http://localhost:8080/aggiorna-cd");
    oss.subscribe(c =>
      this.contiDepositi = c.listaConti
    );
  }

  aggiungi() {

    let dto = new ContoDepositoDto();
    dto.contoDeposito = this.contoDeposito;

    let oss = this.http.post<ListaContiDepositoDto>("http://localhost:8080/aggiungi-contodeposito", dto)
    oss.subscribe(r =>
      this.contiDepositi = r.listaConti);
    this.contoDeposito = new ContoDeposito();
  }

  elimina(c:ContoDeposito) {
    let dto = new ContoDepositoDto();
    dto.contoDeposito = c;

    let oss = this.http.post<ListaContiDepositoDto>("http://localhost:8080/elimina-contodeposito", dto)
    oss.subscribe(r =>
      this.contiDepositi = r.listaConti);
  }

  nuovo() { }

}

import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ContoDeposito } from '../conto-deposito';
import { ContoDepositoDto } from '../conto-deposito-dto';
import { ListaContiDepositoDto } from '../lista-conti-deposito-dto';

@Component({
  selector: 'app-gestione-cd',
  templateUrl: './gestione-cd.component.html',
  styleUrls: ['./gestione-cd.component.css']
})
export class GestioneCdComponent implements OnInit {

  contoDeposito = new ContoDeposito();
  contiDepositi: ContoDeposito[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
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

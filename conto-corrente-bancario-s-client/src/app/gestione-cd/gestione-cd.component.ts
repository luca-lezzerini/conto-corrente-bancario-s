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
  stato = "Gestione-Cd";
  editableInput = false;

  constructor(private http: HttpClient) {
    this.aggiorna();
  }

  ngOnInit(): void {
  }

  aggiorna() {
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

  elimina(c: ContoDeposito) {
    this.stato = "cancella";
    this.contoDeposito = c;
    this.editableInput = true;
  }

  nuovo() { }

  seleziona(c: ContoDeposito) {
    let dto = new ContoDepositoDto();
    dto.contoDeposito = c;

    this.http.post<ContoDepositoDto>("http://localhost:8080/seleziona-cd", dto)
      .subscribe(cd => {
        this.contoDeposito = cd.contoDeposito;
        this.stato = "modifica";
      });
  }

  conferma() {
    switch (this.stato) {
      case "modifica":
        let dto = new ContoDepositoDto();
        dto.contoDeposito = this.contoDeposito;

        this.http.post<ListaContiDepositoDto>("http://localhost:8080/conferma-modifica-cd", dto)
          .subscribe(cd => {
            this.contiDepositi = cd.listaConti;
            this.contoDeposito = new ContoDeposito();
            this.stato = "Gestione-Cd";
          });
        break;
      case "cancella":
        let dtoCanc = new ContoDepositoDto();
        dtoCanc.contoDeposito = this.contoDeposito;

        let oss = this.http.post<ListaContiDepositoDto>("http://localhost:8080/elimina-contodeposito", dtoCanc)
        oss.subscribe(r =>
          this.contiDepositi = r.listaConti);

        this.stato = "Gestione-Cd";
        this.editableInput = false;
        this.contoDeposito = new ContoDeposito();
        break;

      default:
        console.log("Errore conferma");
    }



  }

  annulla() {
    this.contoDeposito = new ContoDeposito();
    console.log(this.stato);
    this.stato = "Gestione-Cd";
    this.editableInput = false;
  }
}

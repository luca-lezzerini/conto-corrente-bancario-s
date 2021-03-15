import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ContoDeposito } from '../conto-deposito';
import { ContoDepositoDto } from '../dto/conto-deposito-dto';
import { RicercaContoCorrenteDto } from '../dto/ricerca-conto-corrente-dto';

@Component({
  selector: 'app-movimenta-cd',
  templateUrl: './movimenta-cd.component.html',
  styleUrls: ['./movimenta-cd.component.css']
})
export class MovimentaCdComponent implements OnInit {
  contactForm: FormGroup;
  operazioni = [
    { id: 1, name: "Deposito" },
    { id: 2, name: "Riscatto" }
  ];
  codiceConto = "";
  contoDeposito = new ContoDeposito();
  contoSelezionato = "";
  importo: number;
  erroreConto = "";
  constructor(private http: HttpClient, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.contactForm = this.fb.group({
      operazione: [1]
    });
  }
  cerca() {
    this.contoSelezionato = "";
    let ric = new RicercaContoCorrenteDto();
    ric.codiceEsatto = this.codiceConto;
    if (this.codiceConto == "") {
      console.log("Nessun conto selezionato");
      this.erroreConto = "Nessun conto selezionato";
    } else {
      this.erroreConto = "";
      this.http.post<ContoDepositoDto>("http://localhost:8080/ricerca-cd", ric)
        .subscribe(r => {
          if (r.contoDeposito == null) {
            this.erroreConto = "Nessun conto trovato";
          } else {
            this.erroreConto = "";
            this.contoSelezionato = r.contoDeposito.codice;
          }
        });
    }
  }
  esegui() {
    console.log("Modulo inviato")
    console.log(this.contactForm.value)
    //   if (this.contactForm.value) {
    //     console.log("Sono nel deposito");
    //   } else if (this.contactForm.value) {
    //     console.log("Sono nel riscatto");
    //   }
    // }
  }
}
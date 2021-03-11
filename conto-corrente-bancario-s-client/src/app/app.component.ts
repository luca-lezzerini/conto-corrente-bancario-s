import { HttpClient} from '@angular/common/http';
import { Component } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteDto } from './clienteDto';
import { ListaClientiDto } from './listaClientiDto';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  cliente = new Cliente();
  clienti : Cliente[] = [];

  constructor(private http:HttpClient){}

  aggiungi(){
    
    //preparo i dati
    let dto = new ClienteDto;
    dto.cliente = this.cliente;
    //invio i dati al server
    let oss = this.http.post<ListaClientiDto>("http://localhost:8080/aggiungi", dto);
    oss.subscribe( c =>
      this.clienti = c.clienti
      );
     this.cliente = new Cliente();
    }

    nuovo(){}
}

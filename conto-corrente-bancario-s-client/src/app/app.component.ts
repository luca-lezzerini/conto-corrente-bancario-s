import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Cliente } from './cliente';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  cliente: Cliente = new Cliente();
  clienti: Cliente[] = [];

  constructor(private htttp: HttpClient) { }

nuovo(){

}
aggiungi(){

}
modifica(){

}
cancella(){
  
}


}

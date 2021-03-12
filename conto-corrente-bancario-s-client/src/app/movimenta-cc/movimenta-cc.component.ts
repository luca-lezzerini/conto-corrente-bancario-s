import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movimenta-cc',
  templateUrl: './movimenta-cc.component.html',
  styleUrls: ['./movimenta-cc.component.css']
})
export class MovimentaCcComponent implements OnInit {

  CodiceConto = "";
  Importo = "";

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  cerca() { }

  esegui() { }

  seleziona() { }

}




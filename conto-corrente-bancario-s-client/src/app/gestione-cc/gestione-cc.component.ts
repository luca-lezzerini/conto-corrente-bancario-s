import { HttpClient } from '@angular/common/http';
import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gestione-cc',
  templateUrl: './gestione-cc.component.html',
  styleUrls: ['./gestione-cc.component.css']
})
export class GestioneCcComponent implements OnInit {

  constructor(private route: Route, private http: HttpClient) { }
  // showForm = false;
  ngOnInit(): void {
  }

  new() {
    // this.showForm = true;
  }

  aggiungi() {

  }
}

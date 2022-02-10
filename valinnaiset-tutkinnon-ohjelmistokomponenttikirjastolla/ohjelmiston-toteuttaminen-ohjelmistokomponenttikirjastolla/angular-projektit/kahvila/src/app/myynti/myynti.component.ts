import { Component, Input, OnInit } from '@angular/core';
import { faCoffee } from '@fortawesome/free-solid-svg-icons'

@Component({
  selector: 'app-myynti',
  templateUrl: './myynti.component.html',
  styleUrls: ['./myynti.component.css']
})
export class MyyntiComponent implements OnInit {

  faCoffee =  faCoffee;
  @Input('tarjoilijalle') ohje!: {tyo:string, poydanNumero:string, myyntiMaara:string};
  constructor() { }

  ngOnInit(): void {
  }

}

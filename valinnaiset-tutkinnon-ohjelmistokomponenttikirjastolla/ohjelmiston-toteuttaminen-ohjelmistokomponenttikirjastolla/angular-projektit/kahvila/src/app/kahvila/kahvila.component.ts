import { Component, OnInit, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-kahvila',
  templateUrl: './kahvila.component.html',
  styleUrls: ['./kahvila.component.css']
})
export class KahvilaComponent implements OnInit {

  
  uusipoydanNumero = '';
  uusimyyntiMaara = '';
  // myyntiTapahtuma: any;
  // tarjoiluTapahtuma: any;
  @Output() myyntiTapahtuma = new EventEmitter<{poydanNumero:string, myyntiMaara: string}>(); 

  @Output() tarjoiluTapahtuma = new EventEmitter<{poydanNumero:string, myyntiMaara: string}>(); 

  constructor() { }

  ngOnInit(): void {
  }

  kahvinMyyty() {
    this.myyntiTapahtuma.emit({
      
      poydanNumero: this.uusipoydanNumero,
      myyntiMaara: this.uusimyyntiMaara
    });
  }

  kahvinTarjoiltu() {
    this.tarjoiluTapahtuma.emit({
      
      poydanNumero: this.uusipoydanNumero,
      myyntiMaara: this.uusimyyntiMaara
    });
  }

}


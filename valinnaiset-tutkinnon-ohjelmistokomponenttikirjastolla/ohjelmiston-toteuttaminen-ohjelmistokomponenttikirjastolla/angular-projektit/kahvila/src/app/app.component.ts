import { Component } from '@angular/core';
;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  tarjoiluOhje = [{tyo:'myyty', poydanNumero:'11', myyntiMaara:'2'}];
  
  kahvinMyynti(myyntiData: {poydanNumero:string, myyntiMaara:string}) {
    this.tarjoiluOhje.push( {
      tyo: 'myyty',
      poydanNumero: myyntiData.poydanNumero,
      myyntiMaara: myyntiData.myyntiMaara
    })
  }

  kahvinTarjoilu(tarjoiluData: {poydanNumero:string, myyntiMaara:string}) {
    this.tarjoiluOhje.push({
      tyo: 'tarjoiltu',
      poydanNumero: tarjoiluData.poydanNumero,
      myyntiMaara: tarjoiluData.myyntiMaara
    });
  }
  
}
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-display-time',
  templateUrl: './display-time.component.html',
  styleUrls: ['./display-time.component.css']
})
export class DisplayTimeComponent implements OnInit {
  dateTime!: Date;
  isShow = true;

  countTime = [] as any;
  
  constructor() { }

  ngOnInit(): void  {
    
    
  }
  toggleDisplay() {
    this.isShow = !this.isShow;
  }

  saveTime() {
    this.dateTime = new Date();
    this.countTime.push(this.dateTime);
    console.log(this.countTime);
    
  }

}

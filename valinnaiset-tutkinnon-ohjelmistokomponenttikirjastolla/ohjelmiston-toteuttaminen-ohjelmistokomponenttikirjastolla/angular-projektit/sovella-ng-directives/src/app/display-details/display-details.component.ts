import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-display-details',
  templateUrl: './display-details.component.html',
  styleUrls: ['./display-details.component.css']
})
export class DisplayDetailsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  isShow = true;
  counts = 0;
  countArray = [] as any;
  toggleDisplay() {
    this.isShow = !this.isShow;
  }

  countClick() {
    return this.counts = this.counts + 1;
  }
  saveCount(){
    this.countArray.push(this.countArray.length + 1);
    console.log(this.countArray);
  
  }
  
}

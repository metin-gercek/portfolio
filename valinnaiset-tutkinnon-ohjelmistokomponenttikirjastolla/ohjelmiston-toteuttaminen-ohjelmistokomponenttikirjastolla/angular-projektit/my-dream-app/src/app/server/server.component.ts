import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-server',
  //selector: '[app-server]',
  //selector: '.app-server' ,
  templateUrl: './server.component.html',
  styleUrls: ['./server.component.css']
})
export class ServerComponent implements OnInit {
  serverId: number = 19;
  serverStatus: string = 'offline';

  getServerStatus() {
    return this.serverStatus;
  }

  getColor() {
    return this.serverStatus === 'online' ? 'green': 'red';
  }

  constructor() {
    //Math.random() arpoo luvun väliltä 0-1 --> molempien vaihtoehtojen tod näk 50%
    this.serverStatus = Math.random() > 0.5 ? 'online' : 'offline';
   }

  ngOnInit(): void {
  }

}

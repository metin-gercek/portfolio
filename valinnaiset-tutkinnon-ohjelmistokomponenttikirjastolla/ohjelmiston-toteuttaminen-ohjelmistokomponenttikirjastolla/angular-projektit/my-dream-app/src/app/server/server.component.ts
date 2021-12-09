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

  constructor() { }

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import { faExclamationTriangle } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-danger',
  templateUrl: './danger.component.html',
  styleUrls: ['./danger.component.css']
})
export class DangerComponent implements OnInit {
  faExclamationTriangle = faExclamationTriangle;

  constructor() { }

  ngOnInit(): void {
  }

}

import { Component, OnInit } from '@angular/core';
import { faThumbsUp, faSkullCrossbones} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-warning',
  templateUrl: './warning.component.html',
  styleUrls: ['./warning.component.css']
})
export class WarningComponent implements OnInit {
  faThumbsUp = faThumbsUp;
  faSkullCrossbones = faSkullCrossbones;


  constructor() { }

  ngOnInit(): void {
  }

}

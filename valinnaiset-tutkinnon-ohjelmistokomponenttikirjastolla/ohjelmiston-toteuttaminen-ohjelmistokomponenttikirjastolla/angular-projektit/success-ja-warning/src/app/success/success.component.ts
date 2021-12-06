import { Component, OnInit } from '@angular/core';
import { faThumbsUp, faSkullCrossbones} from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent implements OnInit {
  faThumbsUp = faThumbsUp;
  faSkullCrossbones = faSkullCrossbones;

  constructor() { }

  ngOnInit(): void {
  }

}

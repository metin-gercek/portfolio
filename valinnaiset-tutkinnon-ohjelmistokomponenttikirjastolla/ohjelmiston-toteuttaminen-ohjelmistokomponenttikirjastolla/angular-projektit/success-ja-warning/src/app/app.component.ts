import { Component } from '@angular/core';

import { faThumbsUp, faSkullCrossbones} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'success-ja-warning';
  faThumbsUp = faThumbsUp;
  faSkullCrossbones = faSkullCrossbones;
}

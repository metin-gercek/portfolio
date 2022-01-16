import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DisplayDetailsComponent } from './display-details/display-details.component';
import { DisplayTimeComponent } from './display-time/display-time.component';

@NgModule({
  declarations: [
    AppComponent,
    DisplayDetailsComponent,
    DisplayTimeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

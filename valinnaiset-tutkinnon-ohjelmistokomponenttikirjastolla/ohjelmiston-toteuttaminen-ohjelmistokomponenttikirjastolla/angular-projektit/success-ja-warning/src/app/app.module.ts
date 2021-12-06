import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SuccessComponent } from './success/success.component';
import { WarningComponent } from './warning/warning.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { DangerComponent } from './danger/danger.component';
import { InfoComponent } from './info/info.component';

@NgModule({
  declarations: [
    AppComponent,
    SuccessComponent,
    WarningComponent,
    DangerComponent,
    InfoComponent
  ],
  imports: [
    BrowserModule,
    FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

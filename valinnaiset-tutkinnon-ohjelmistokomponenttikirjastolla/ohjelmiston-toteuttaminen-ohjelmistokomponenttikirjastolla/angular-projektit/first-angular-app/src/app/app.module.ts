// import { NgModule } from '@angular/core';
// import { BrowserModule } from '@angular/platform-browser';

// import { AppComponent } from './app.component';
// import { CustomersComponent } from './customers/customers.component';

// @NgModule({
//   declarations: [
//     AppComponent,
//     CustomersComponent
//   ],
//   imports: [
//     BrowserModule
//   ],
//   providers: [],
//   bootstrap: [AppComponent]
// })
// export class AppModule { }
import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { CustomersModule } from './customers/customers.module';
import { AppComponent }  from './app.component';
import { SharedComponent } from './shared/shared.component';
import { SharedModule } from './shared/shared.module';


@NgModule({
  imports:      [ BrowserModule, CustomersModule, SharedModule ],
  declarations: [ AppComponent, SharedComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
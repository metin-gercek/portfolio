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
import { CoreModule } from './core/core.module';
import { CustomersModule } from './customers/customers.module';
import { AppComponent }  from './app.component';
import { SharedComponent } from './shared/shared.component';
import { SharedModule } from './shared/shared.module';
import { AppRoutingModule } from './app-routing.module';
import { OrdersComponent } from './orders/orders.component';
import { OrdersModule } from './orders/orders.module';


@NgModule({
  imports:      [ BrowserModule, CoreModule, CustomersModule, OrdersModule, SharedModule, AppRoutingModule ],
  declarations: [ AppComponent, SharedComponent, OrdersComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
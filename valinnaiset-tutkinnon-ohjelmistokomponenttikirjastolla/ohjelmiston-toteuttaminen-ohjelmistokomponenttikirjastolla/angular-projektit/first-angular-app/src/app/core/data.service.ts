import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { ICustomer, IOrder } from '../../app/shared/interfaces';
import { noUndefined } from '@angular/compiler/src/util';

@Injectable()
export class DataService {
    // Use the following properties if running the Docker containers via Docker Compose
    // customersUrl = 'http://localhost:3000/api/customers';
    // ordersUrl = 'http://localhost:3000/api/orders';

    // Use the following properties if running the app stand-alone with no external dependencies
    customersUrl = 'assets/customers.json';
    ordersUrl = 'assets/orders.json';
    baseUrl!: string;

    constructor(private http: HttpClient) { }

    getCustomers(): Observable<ICustomer[]> {
      return this.http.get<ICustomer[]>(this.customersUrl)
        .pipe(
          catchError(this.handleError)
        );

    }

    getCustomer(id: number) : Observable<ICustomer> {
      return this.http.get<ICustomer[]>(this.baseUrl + 'customers.json')
        .pipe(
          map(customers => {
            let customer = customers.filter((cust: ICustomer) => cust.id === id);
            return (customer && customer.length) ? customer[0] : null;
          }),
          catchError(this.handleError)
        )
    }

    getOrders(id: number) : Observable<IOrder[]> {
      return this.http.get<IOrder[]>(this.baseUrl + 'orders.json')
        .pipe(
          map(orders => {
            let custOrders = orders.filter((order: IOrder) => order.customerId === id);
            return custOrders;
          }),
          catchError(this.handleError)
        );
    }


    
    private handleError(error: any) {
      console.error('server error:', error);
      if (error.error instanceof Error) {
          const errMessage = error.error.message;
          return throwError(errMessage);
      }
      return throwError(error || 'Server error');
    }

}
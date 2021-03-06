import { Component } from '@angular/core';
import { Product } from './product.model';

import { ProductRepository } from './repository.model';

@Component({
  selector: 'app',
  templateUrl: 'product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {

  model: ProductRepository = new ProductRepository();
  productName: string = this.model.getProductById(1).name;
  addProduct(){
    this.model.addProduct(new Product(6, "Samsung S19", "good phone", "4.jpg", 800));
  }

  deleteProduct(product: Product) {
    this.model.deleteProduct(product);
  }

  updateProduct(product:Product) {
    product.name = "updated";
  }
  email = "email@gmail.com";
  onKeyUp()  {
    // this.values += event.target.value;
      console.log(this.email);
    
  }
  // disabled = false;
  // constructor() { }

  // getClasses(id: number) : string {
  //   let product = this.model.getProductById(id);
  //   return (product.price <= 1000 ? "bg-info text-white": "bg-secondary") + " m-2 p-2";
  // }

  // product: Product = this.model.getProductById(1);

  // getClassMap(id: number): Object {
  //   let product = this.model.getProductById(id);
  //   return {
  //     "bg-info": product.price <=1000,
  //     "bg-secondary": product.price > 1000,
  //     "text-center text-white": product.name == "Samsung Z"
  //   }
  // }

  // color: string = this.model.getProductById(1).price <= 1000? "red": "blue";
  // fontSize: string = "25px";

  // getStyles(id: number) {
  //   let product = this.model.getProductById(id);
  //   return {
  //     fontSize: "25px",
  //     color: product.price <= 1000 ? "green" : "red"
  //   }
  // }

  // onSubmit($event: any) {
  //   $event.stopPropagation();
  //   console.log('button was clicked');
  //   console.log($event);
  // }
  // onDivClicked() {
  //   console.log('div was clicked');
  // }

  // values = '';
  
}

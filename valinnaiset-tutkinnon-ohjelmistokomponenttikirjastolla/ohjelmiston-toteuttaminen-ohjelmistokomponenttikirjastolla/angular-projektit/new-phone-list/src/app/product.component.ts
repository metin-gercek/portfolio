import { products } from './../../../angular-tutorial-mystore/src/app/products';
import { ProductRepository } from './../../../free-angular-project/src/app/repository.model';

import { Component } from "@angular/core";
import { Product } from './product.model';

@Component({
  selector: "app",
  templateUrl: "product.component.html",
  styleUrls: ["product.component.css"]
})

export class ProductComponent {
  model: ProductRepository = new ProductRepository();

  product: Product = this.model.getProductById(1);

}

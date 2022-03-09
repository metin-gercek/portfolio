
import { ProductRepository } from './repository.model';
import { Product } from './product.model';
import { Component } from "@angular/core";


@Component({
  selector: "app",
  templateUrl: "product.component.html",
  styleUrls: ["product.component.css"]
})

export class ProductComponent {
  model: ProductRepository = new ProductRepository();

  getClasses(id: number) : string {
    let product = this.model.getProductById(id);
    console.log(product.price);
    return (product.price < 1000 ? "bg-primary text-white": "bg-secondary") + " m-2 p-2";
  }



}

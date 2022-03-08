import { Product } from './../../../free-angular-project/src/app/product.model';
import { products } from './../../../angular-tutorial-mystore/src/app/products';


export class SimpleDataSource {
  private products: Product[];

  constructor() {
    this.products = new Array<Product>(
      new Product(1, "Samsung S15", "good phone", "1.jpg", 600),
      new Product(2, "Samsung S16", "good phone", "1.jpg", 700),
      new Product(3, "Samsung S17", "good phone", "1.jpg", 800),
      new Product(4, "Samsung S18", "good phone", "1.jpg", 900),
      new Product(5, "Samsung S19", "good phone", "1.jpg", 1000),
      new Product(6, "Samsung S20", "good phone", "1.jpg", 1100)
    );
  }

  getProducts() {
    return this.products;
  }



}

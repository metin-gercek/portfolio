import { Product } from './../../../free-angular-project/src/app/product.model';
import { SimpleDataSource } from './../../../free-angular-project/src/app/datasource.model';


export class ProductRespository {
  private dataSource: SimpleDataSource;
  private products: Product[] | any;

  constructor() {
    this.dataSource = new SimpleDataSource;
    this.products = new Array<Product>();
    this.dataSource.getProducts().forEach(p => this.products.push(p));
  }

  getProducts(): Product[] {
    return this.products;
  }

  getProductById(id: number): Product {
    return this.products.find((p: { id: number; }) => p.id == id);
  }

}

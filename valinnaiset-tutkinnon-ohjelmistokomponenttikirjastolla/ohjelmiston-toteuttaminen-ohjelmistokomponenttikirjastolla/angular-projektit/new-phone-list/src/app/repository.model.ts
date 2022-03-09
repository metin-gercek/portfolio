import { Product } from './product.model';
import { SimpleDataSource } from './datasource.model';


export class ProductRepository {
  private dataSource!: SimpleDataSource;
  private products!: Product[];

  constructor() {
    this.dataSource = new SimpleDataSource;
    this.products = new Array<Product>();
    this.dataSource.getProducts().forEach(p => this.products.push(p));
  }

  getProducts(): Product[] {
    return this.products;
  }

  getProductById(id: number): Product | any {
    return this.products.find(p => p.id == id);
}

}

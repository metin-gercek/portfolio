import { Product } from "./product.model";


export class SimpleDataSource {
    private products!: Product[];

    constructor() {
        this.products = new Array<Product>(
            new Product(1, "Samsung S21", "good phone", "1.jpg", 1500),
            new Product(2, "Samsung Z", "good phone", "2.jpg", 1200),
            new Product(3, "Samsung Galaxy Note", "good phone", "3.jpg", 1000),
            new Product(4, "Samsung A", "good phone", "4.jpg", 1100),
            new Product(5, "Samsung Tab S7", "good phone", "5.jpg", 900),
        )
    }

    getProducts(): Product[] {
        return this.products;
    }
}
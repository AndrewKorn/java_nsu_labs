package Factory.Factories;

import Factory.Products.ConcreteProduct;

public interface ProductFactory<T extends ConcreteProduct> {
    T createProduct();
}

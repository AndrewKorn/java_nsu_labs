package Factory.Workers.Suppliers;

import Factory.Factories.ProductFactory;
import Factory.Products.Body;
import Factory.Warehouses.ConcreteWarehouse;
import Factory.Warehouses.ProductsCounter;

public class BodySupplier extends Supplier<Body> {
    public BodySupplier(ConcreteWarehouse<Body> warehouse, ProductFactory<Body> factory, ProductsCounter<Body> productsCounter, int waitTime) {
        super(warehouse, factory, productsCounter, waitTime);
    }
}

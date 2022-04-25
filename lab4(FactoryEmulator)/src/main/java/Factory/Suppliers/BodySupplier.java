package Factory.Suppliers;

import Factory.Factories.ProductFactory;
import Factory.Products.Body;
import Factory.Warehouses.ConcreteWarehouse;

public class BodySupplier extends Supplier<Body> {
    public BodySupplier(ConcreteWarehouse<Body> warehouse, ProductFactory<Body> factory, int waitTime) {
        super(warehouse, factory, waitTime);
    }
}

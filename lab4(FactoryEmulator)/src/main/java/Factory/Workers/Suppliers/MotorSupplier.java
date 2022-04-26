package Factory.Workers.Suppliers;

import Factory.Factories.ProductFactory;
import Factory.Products.Motor;
import Factory.Warehouses.ConcreteWarehouse;
import Factory.Warehouses.ProductsCounter;

public class MotorSupplier extends Supplier<Motor> {
    public MotorSupplier(ConcreteWarehouse<Motor> warehouse, ProductFactory<Motor> factory, ProductsCounter<Motor> productsCounter, int waitTime) {
        super(warehouse, factory, productsCounter, waitTime);
    }
}

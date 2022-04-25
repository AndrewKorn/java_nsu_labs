package Factory.Suppliers;

import Factory.Factories.ProductFactory;
import Factory.Products.Motor;
import Factory.Warehouses.ConcreteWarehouse;

public class MotorSupplier extends Supplier<Motor> {
    public MotorSupplier(ConcreteWarehouse<Motor> warehouse, ProductFactory<Motor> factory, int waitTime) {
        super(warehouse, factory, waitTime);
    }
}

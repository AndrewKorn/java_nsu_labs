package Factory.Suppliers;

import Factory.Factories.ProductFactory;
import Factory.Products.Accessory;
import Factory.Warehouses.ConcreteWarehouse;

public class AccessorySupplier extends Supplier<Accessory> {
    public AccessorySupplier(ConcreteWarehouse<Accessory> warehouse, ProductFactory<Accessory> factory, int waitTime) {
        super(warehouse, factory, waitTime);
    }
}

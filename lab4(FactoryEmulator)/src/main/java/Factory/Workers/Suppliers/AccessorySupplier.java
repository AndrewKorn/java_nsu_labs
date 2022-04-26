package Factory.Workers.Suppliers;

import Factory.Factories.ProductFactory;
import Factory.Products.Accessory;
import Factory.Warehouses.ConcreteWarehouse;
import Factory.Warehouses.ProductsCounter;

public class AccessorySupplier extends Supplier<Accessory> {
    public AccessorySupplier(ConcreteWarehouse<Accessory> warehouse, ProductFactory<Accessory> factory, ProductsCounter<Accessory> productsCounter, int waitTime) {
        super(warehouse, factory, productsCounter, waitTime);
    }
}

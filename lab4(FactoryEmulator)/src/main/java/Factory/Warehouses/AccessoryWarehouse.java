package Factory.Warehouses;

import Factory.Products.Accessory;

public class AccessoryWarehouse extends ConcreteWarehouse<Accessory> {

    public AccessoryWarehouse(int warehouseSize) {
        super(warehouseSize);
    }
}

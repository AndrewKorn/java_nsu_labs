package Factory.Warehouses;

import Factory.Products.Body;

public class BodyWarehouse extends ConcreteWarehouse<Body> {

    public BodyWarehouse(int warehouseSize) {
        super(warehouseSize);
    }
}

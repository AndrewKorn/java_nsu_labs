package Factory.Warehouses;

import Factory.Products.Motor;

public class MotorWarehouse extends ConcreteWarehouse<Motor> {
    public MotorWarehouse(int warehouseSize) {
        super(warehouseSize);
    }
}

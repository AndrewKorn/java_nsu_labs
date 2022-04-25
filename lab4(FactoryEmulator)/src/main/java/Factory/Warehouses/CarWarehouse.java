package Factory.Warehouses;

import Factory.Products.Car;

public class CarWarehouse extends ConcreteWarehouse<Car> {
    public CarWarehouse(int warehouseSize) {
        super(warehouseSize);
    }
}

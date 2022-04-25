package Factory.Suppliers;

import Factory.Factories.ProductFactory;
import Factory.Products.ConcreteProduct;
import Factory.Warehouses.ConcreteWarehouse;

public class Supplier<T extends ConcreteProduct> extends Thread {
    private final ConcreteWarehouse<T> warehouse;
    private final ProductFactory<T> factory;
    private final int waitTime;

    public Supplier(ConcreteWarehouse<T> warehouse, ProductFactory<T> factory, int waitTime) {
        super();
        this.warehouse = warehouse;
        this.factory = factory;
        this.waitTime = waitTime;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            warehouse.putProduct(factory.createProduct());
        }
    }
}

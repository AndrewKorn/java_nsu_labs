package Factory.Workers.Suppliers;

import Factory.Factories.ProductFactory;
import Factory.Products.ConcreteProduct;
import Factory.Warehouses.ConcreteWarehouse;
import ThreadPool.Task;

public class Supplier<T extends ConcreteProduct> implements Task {
    private final ConcreteWarehouse<T> warehouse;
    private final ProductFactory<T> factory;
    private final int waitTime;

    public Supplier(ConcreteWarehouse<T> warehouse, ProductFactory<T> factory, int waitTime) {
        super();
        this.warehouse = warehouse;
        this.factory = factory;
        this.waitTime = waitTime;
    }

    @Override
    public String getName() {
        return "Accessory supplier";
    }

    @Override
    public void performWork() throws InterruptedException {
        while (true) {
            warehouse.putProduct(factory.createProduct());

            Thread.sleep(waitTime);
        }
    }
}

package Factory.Workers.Suppliers;

import Factory.Factories.ProductFactory;
import Factory.Products.ConcreteProduct;
import Factory.Warehouses.ConcreteWarehouse;
import Factory.Warehouses.ProductsCounter;
import ThreadPool.Task;

public class Supplier<T extends ConcreteProduct> implements Task {
    private final ConcreteWarehouse<T> warehouse;
    private final ProductFactory<T> factory;
    private final ProductsCounter<T> productsCounter;
    private final int waitTime;

    public Supplier(ConcreteWarehouse<T> warehouse, ProductFactory<T> factory, ProductsCounter<T> productsCounter, int waitTime) {
        super();
        this.warehouse = warehouse;
        this.factory = factory;
        this.productsCounter = productsCounter;
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
            productsCounter.increment();
            Thread.sleep(waitTime);
        }
    }
}

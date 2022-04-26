package Factory.Warehouses;

import Factory.General.ConcretePublisher;
import Factory.Products.ConcreteProduct;

public class ProductsCounter<T extends ConcreteProduct> extends ConcretePublisher {
    private int count = 0;

    public synchronized void increment() {
        ++count;
        notifySubscriber();
    }

    public int getCount() {
        return count;
    }
}

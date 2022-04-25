package Factory.Warehouses;

import Factory.Products.ConcreteProduct;

public interface Warehouse<T extends ConcreteProduct> {
    int getSize();
    int getCount();
    T getProduct();
    void putProduct(T product);
    boolean isEmpty();
    boolean isFull();
}

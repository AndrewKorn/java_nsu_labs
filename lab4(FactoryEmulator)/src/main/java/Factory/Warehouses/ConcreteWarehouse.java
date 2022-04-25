package Factory.Warehouses;

import Factory.Products.ConcreteProduct;
import com.sun.jdi.event.ThreadStartEvent;

import java.util.LinkedList;
import java.util.Queue;

public class ConcreteWarehouse<T extends ConcreteProduct> implements Warehouse<T> {
    private final int warehouseSize;
    private final Queue<T> queue;

    public ConcreteWarehouse(int warehouseSize) {
        this.warehouseSize = warehouseSize;
        this.queue = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return warehouseSize;
    }

    @Override
    public int getCount() {
        return queue.size();
    }

    @Override
    public synchronized T getProduct() {
        while (true) {
            if(!isEmpty()) {
                T product = queue.remove();
                notify();
                return product;
            }
            else {
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public synchronized void putProduct(T product) {
        if (!isFull()) {
            queue.add(product);
            notify();
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isFull() {
        return (warehouseSize == queue.size());
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

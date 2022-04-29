package Factory.Workers;

import Factory.General.ConcretePublisher;
import Factory.Products.Car;
import Factory.Warehouses.ConcreteWarehouse;
import Factory.ProductsCounters.ProductsCounter;
import ThreadPool.Task;

public class Dealer extends ConcretePublisher implements Task {
    private final String name;
    private final ConcreteWarehouse<Car> carWarehouse;
    private final ProductsCounter<Car> carsSoldCounter;
    private int waitTime;

    public Dealer(String name, ConcreteWarehouse<Car> carWarehouse, ProductsCounter<Car> carsSoldCounter, int waitTime) {
        super();
        this.name = name;
        this.carWarehouse = carWarehouse;
        this.carsSoldCounter = carsSoldCounter;
        this.waitTime = waitTime;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void performWork() throws InterruptedException {
        while (true) {
            Car car = carWarehouse.getProduct();
            carsSoldCounter.increment();
            System.out.println(name + ": Car<" + car.getID() + "> (Body:<" + car.getBody().getID() + ">, Motor:<" + car.getMotor().getID() + ">, Accessory:<" + car.getAccessory().getID() + ">)");
            Thread.sleep(waitTime);
        }
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
}

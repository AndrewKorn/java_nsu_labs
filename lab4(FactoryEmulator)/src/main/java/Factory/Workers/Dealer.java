package Factory.Workers;

import Factory.General.ConcretePublisher;
import Factory.General.FactoryLogger;
import Factory.Products.Car;
import Factory.Warehouses.ConcreteWarehouse;
import Factory.ProductsCounters.ProductsCounter;
import ThreadPool.Task;

public class Dealer extends ConcretePublisher implements Task {
    private final String name;
    private final FactoryLogger logger;
    private final ConcreteWarehouse<Car> carWarehouse;
    private final ProductsCounter<Car> carsSoldCounter;
    private int waitTime;

    public Dealer(String name, FactoryLogger logger, ConcreteWarehouse<Car> carWarehouse, ProductsCounter<Car> carsSoldCounter, int waitTime) {
        super();
        this.name = name;
        this.logger = logger;
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
            logger.getInfoMessage(name + ": Car<" + car.getID() + "> (Body:<" + car.getBody().getID() + ">, Motor:<" + car.getMotor().getID() + ">, Accessory:<" + car.getAccessory().getID() + ">)");
            Thread.sleep(waitTime);
        }
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
}

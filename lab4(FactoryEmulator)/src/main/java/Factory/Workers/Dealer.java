package Factory.Workers;

import Factory.General.ConcretePublisher;
import Factory.Products.Car;
import Factory.Warehouses.CarWarehouse;
import ThreadPool.Task;

public class Dealer extends ConcretePublisher implements Task {
    private final String name;
    private final CarWarehouse carWarehouse;

    private final int waitTime;

    public Dealer(String name, CarWarehouse carWarehouse, int waitTime) {
        super();
        this.name = name;
        this.carWarehouse = carWarehouse;
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
            System.out.println(name + ": Car<" + car.getID() + "> (Body:<" + car.getBody().getID() + ">, Motor:<" + car.getMotor().getID() + ">, Accessory:<" + car.getAccessory().getID() + ">)");
            Thread.sleep(waitTime);
        }
    }
}

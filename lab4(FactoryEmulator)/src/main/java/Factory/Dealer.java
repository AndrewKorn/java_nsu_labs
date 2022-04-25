package Factory;

import Factory.Products.Car;
import Factory.Warehouses.CarWarehouse;

public class Dealer extends Thread {
    private final String name;
    private final CarWarehouse carWarehouse;
    private final int waitTime;

    public Dealer(String name, CarWarehouse carWarehouse, int waitTime) {
        super();
        this.name = name;
        this.carWarehouse = carWarehouse;
        this.waitTime = waitTime;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Car car = carWarehouse.getProduct();
            System.out.println(name + ": Car<" + car.getID() + "> (Body:<" + car.getBody().getID() + ">, Motor:<" + car.getMotor().getID() + ">, Accessory:<" + car.getAccessory().getID() + ">)");
        }
    }
}

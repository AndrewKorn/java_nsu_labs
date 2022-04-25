package Factory;

import Factory.Factories.CarBuilder;
import Factory.Products.Accessory;
import Factory.Products.Body;
import Factory.Products.Car;
import Factory.Products.Motor;
import Factory.Warehouses.AccessoryWarehouse;
import Factory.Warehouses.BodyWarehouse;
import Factory.Warehouses.CarWarehouse;
import Factory.Warehouses.MotorWarehouse;
import ThreadPool.Task;

public class Worker implements Task {
    private final String name;
    private final BodyWarehouse bodyWarehouse;
    private final MotorWarehouse motorWarehouse;
    private final AccessoryWarehouse accessoryWarehouse;
    private final CarBuilder carBuilder;
    private final CarWarehouse carWarehouse;
    private final int waitTime;


    public Worker(
            String name,
            BodyWarehouse bodyWarehouse,
            MotorWarehouse motorWarehouse,
            AccessoryWarehouse accessoryWarehouse,
            CarBuilder carBuilder,
            CarWarehouse carWarehouse,
            int waitTime
    ) {
        this.name = name;
        this.bodyWarehouse = bodyWarehouse;
        this.motorWarehouse = motorWarehouse;
        this.accessoryWarehouse = accessoryWarehouse;
        this.carBuilder = carBuilder;
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
            Thread.sleep(waitTime);
            Body body = bodyWarehouse.getProduct();
            Motor motor = motorWarehouse.getProduct();
            Accessory accessory = accessoryWarehouse.getProduct();

            Car car = carBuilder.buildCar(body, motor, accessory);
            carWarehouse.putProduct(car);
        }
    }
}

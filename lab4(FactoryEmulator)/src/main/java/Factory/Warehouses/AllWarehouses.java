package Factory.Warehouses;

import Factory.General.ConcretePublisher;
import Factory.General.Configuration;
import Factory.General.Subscriber;
import Factory.Products.Accessory;
import Factory.Products.Body;
import Factory.Products.Car;
import Factory.Products.Motor;

public class AllWarehouses extends ConcretePublisher implements Subscriber {
    private final BodyWarehouse bodyWarehouse;
    private final MotorWarehouse motorWarehouse;
    private final AccessoryWarehouse accessoryWarehouse;
    private final CarWarehouse carWarehouse;


    public AllWarehouses(Configuration configuration) {
        bodyWarehouse = new BodyWarehouse(configuration.getBodyWarehouseSize());
        motorWarehouse = new MotorWarehouse(configuration.getMotorWarehouseSize());
        accessoryWarehouse = new AccessoryWarehouse(configuration.getAccessoryWarehouseSize());
        carWarehouse = new CarWarehouse(configuration.getCarWarehouseSize());

        bodyWarehouse.addSubscriber(this);
        motorWarehouse.addSubscriber(this);
        accessoryWarehouse.addSubscriber(this);
        carWarehouse.addSubscriber(this);
    }

    public BodyWarehouse getBodyWarehouse() {
        return bodyWarehouse;
    }

    public MotorWarehouse getMotorWarehouse() {
        return motorWarehouse;
    }

    public AccessoryWarehouse getAccessoryWarehouse() {
        return accessoryWarehouse;
    }

    public CarWarehouse getCarWarehouse() {
        return carWarehouse;
    }

    @Override
    public void reactOnNotify() {
        notifySubscriber();
    }
}

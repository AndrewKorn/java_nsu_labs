package Factory.Warehouses;

import Factory.General.ConcretePublisher;
import Factory.General.Configuration;
import Factory.General.Subscriber;
import Factory.Products.Accessory;
import Factory.Products.Body;
import Factory.Products.Car;
import Factory.Products.Motor;

public class AllWarehouses extends ConcretePublisher implements Subscriber {
    private final ConcreteWarehouse<Body> bodyWarehouse;
    private final ConcreteWarehouse<Motor> motorWarehouse;
    private final ConcreteWarehouse<Accessory> accessoryWarehouse;
    private final ConcreteWarehouse<Car> carWarehouse;


    public AllWarehouses(Configuration configuration) {
        bodyWarehouse = new ConcreteWarehouse<>(configuration.getBodyWarehouseSize());
        motorWarehouse = new ConcreteWarehouse<>(configuration.getMotorWarehouseSize());
        accessoryWarehouse = new ConcreteWarehouse<>(configuration.getAccessoryWarehouseSize());
        carWarehouse = new ConcreteWarehouse<>(configuration.getCarWarehouseSize());

        bodyWarehouse.addSubscriber(this);
        motorWarehouse.addSubscriber(this);
        accessoryWarehouse.addSubscriber(this);
        carWarehouse.addSubscriber(this);
    }

    public ConcreteWarehouse<Body> getBodyWarehouse() {
        return bodyWarehouse;
    }

    public ConcreteWarehouse<Motor> getMotorWarehouse() {
        return motorWarehouse;
    }

    public ConcreteWarehouse<Accessory> getAccessoryWarehouse() {
        return accessoryWarehouse;
    }

    public ConcreteWarehouse<Car> getCarWarehouse() {
        return carWarehouse;
    }

    @Override
    public void reactOnNotify() {
        notifySubscriber();
    }
}

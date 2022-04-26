package Factory.Factories;

import Factory.Factories.AccessoryFactory;
import Factory.Factories.BodyFactory;
import Factory.Factories.CarBuilder;
import Factory.Factories.MotorFactory;

public class AllFactories {
    private final BodyFactory bodyFactory = new BodyFactory();
    private final MotorFactory motorFactory = new MotorFactory();
    private final AccessoryFactory accessoryFactory = new AccessoryFactory();
    private final CarBuilder carBuilder = new CarBuilder();

    public BodyFactory getBodyFactory() {
        return bodyFactory;
    }

    public MotorFactory getMotorFactory() {
        return motorFactory;
    }

    public AccessoryFactory getAccessoryFactory() {
        return accessoryFactory;
    }

    public CarBuilder getCarBuilder() {
        return carBuilder;
    }
}

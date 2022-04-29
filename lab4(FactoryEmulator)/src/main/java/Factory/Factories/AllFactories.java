package Factory.Factories;

public class AllFactories {
    private final BodyFactory bodyFactory = new BodyFactory();
    private final MotorFactory motorFactory = new MotorFactory();
    private final AccessoryFactory accessoryFactory = new AccessoryFactory();
    private final CarFactory carBuilder = new CarFactory();

    public BodyFactory getBodyFactory() {
        return bodyFactory;
    }

    public MotorFactory getMotorFactory() {
        return motorFactory;
    }

    public AccessoryFactory getAccessoryFactory() {
        return accessoryFactory;
    }

    public CarFactory getCarBuilder() {
        return carBuilder;
    }
}

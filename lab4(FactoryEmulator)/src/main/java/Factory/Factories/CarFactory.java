package Factory.Factories;

import Factory.Products.Accessory;
import Factory.Products.Body;
import Factory.Products.Car;
import Factory.Products.Motor;

public class CarFactory {
    private final IndexGiver indexGiver = new IndexGiver();

    public Car buildCar(Body body, Motor motor, Accessory accessory) {
        return new Car(body, motor, accessory, indexGiver.getIndex());
    }
}

package Factory.Products;

public class Car extends ConcreteProduct{
    private final Body body;
    private final Motor motor;
    private final Accessory accessory;

    public Car(Body body, Motor motor, Accessory accessory, int id) {
        super(id);
        this.body = body;
        this.motor = motor;
        this.accessory = accessory;
    }

    public Body getBody() {
        return body;
    }

    public Motor getMotor() {
        return motor;
    }

    public Accessory getAccessory() {
        return accessory;
    }
}

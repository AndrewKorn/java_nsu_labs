package Factory.Factories;

import Factory.Products.Motor;

public class MotorFactory implements ProductFactory<Motor> {
    private final IndexGiver indexGiver = new IndexGiver();

    @Override
    public Motor createProduct() {
        return new Motor(indexGiver.getIndex());
    }
}

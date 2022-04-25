package Factory.Factories;

import Factory.Products.Body;

public class BodyFactory implements ProductFactory<Body>{
    private final IndexGiver indexGiver = new IndexGiver();

    @Override
    public Body createProduct() {
        return new Body(indexGiver.getIndex());
    }
}

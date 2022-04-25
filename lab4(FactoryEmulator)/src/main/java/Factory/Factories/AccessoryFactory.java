package Factory.Factories;

import Factory.Products.Accessory;

public class AccessoryFactory implements ProductFactory<Accessory> {
    private final IndexGiver indexGiver = new IndexGiver();

    @Override
    public synchronized Accessory createProduct() {
        return new Accessory(indexGiver.getIndex());
    }
}

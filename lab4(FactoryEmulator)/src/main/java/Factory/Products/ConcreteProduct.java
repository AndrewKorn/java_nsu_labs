package Factory.Products;

public class ConcreteProduct implements Product {
    private final int id;

    public ConcreteProduct(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }
}

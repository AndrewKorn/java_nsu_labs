package Factory.Warehouses;

import Factory.General.ConcretePublisher;
import Factory.General.Subscriber;
import Factory.Products.Accessory;
import Factory.Products.Body;
import Factory.Products.Car;
import Factory.Products.Motor;

public class AllProductsCounters extends ConcretePublisher implements Subscriber {
    private final ProductsCounter<Body> releasedBodyCounter;
    private final ProductsCounter<Motor> releasedMotorCounter;
    private final ProductsCounter<Accessory> releasedAccessoryCounter;
    private final ProductsCounter<Car> releasedCarCounter;
    private final ProductsCounter<Car> carsSoldCounter;

    public AllProductsCounters() {
        releasedBodyCounter = new ProductsCounter<>();
        releasedMotorCounter = new ProductsCounter<>();
        releasedAccessoryCounter = new ProductsCounter<>();
        releasedCarCounter = new ProductsCounter<>();
        carsSoldCounter = new ProductsCounter<>();

        releasedBodyCounter.addSubscriber(this);
        releasedMotorCounter.addSubscriber(this);
        releasedAccessoryCounter.addSubscriber(this);
        releasedCarCounter.addSubscriber(this);
        carsSoldCounter.addSubscriber(this);
    }

    public ProductsCounter<Body> getReleasedBodyCounter() {
        return releasedBodyCounter;
    }

    public ProductsCounter<Motor> getReleasedMotorCounter() {
        return releasedMotorCounter;
    }

    public ProductsCounter<Accessory> getReleasedAccessoryCounter() {
        return releasedAccessoryCounter;
    }

    public ProductsCounter<Car> getReleasedCarCounter() {
        return releasedCarCounter;
    }

    public ProductsCounter<Car> getCarsSoldCounter() {
        return carsSoldCounter;
    }

    @Override
    public void reactOnNotify() {
        notifySubscriber();
    }
}

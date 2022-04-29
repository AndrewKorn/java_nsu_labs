package Factory.Workers;

import Factory.Factories.CarFactory;
import Factory.Products.Accessory;
import Factory.Products.Body;
import Factory.Products.Car;
import Factory.Products.Motor;
import Factory.ProductsCounters.ProductsCounter;
import Factory.Warehouses.*;
import ThreadPool.Task;

public class Worker implements Task {
    private final String name;
    private final ConcreteWarehouse<Body> bodyWarehouse;
    private final ConcreteWarehouse<Motor> motorWarehouse;
    private final ConcreteWarehouse<Accessory> accessoryWarehouse;
    private final CarFactory carBuilder;
    private final ConcreteWarehouse<Car> carWarehouse;
    private final ProductsCounter<Car> productsCounter;

    public Worker(
            String name,
            ConcreteWarehouse<Body> bodyWarehouse,
            ConcreteWarehouse<Motor> motorWarehouse,
            ConcreteWarehouse<Accessory> accessoryWarehouse,
            CarFactory carBuilder,
            ConcreteWarehouse<Car> carWarehouse,
            ProductsCounter<Car> productsCounter
    ) {
        this.name = name;
        this.bodyWarehouse = bodyWarehouse;
        this.motorWarehouse = motorWarehouse;
        this.accessoryWarehouse = accessoryWarehouse;
        this.carBuilder = carBuilder;
        this.carWarehouse = carWarehouse;
        this.productsCounter = productsCounter;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void performWork() {
        while (true) {
            Body body = bodyWarehouse.getProduct();
            Motor motor = motorWarehouse.getProduct();
            Accessory accessory = accessoryWarehouse.getProduct();
            Car car = carBuilder.buildCar(body, motor, accessory);
            productsCounter.increment();
            carWarehouse.putProduct(car);
        }
    }
}

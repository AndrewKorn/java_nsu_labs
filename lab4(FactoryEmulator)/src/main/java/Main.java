import Factory.*;
import Factory.Factories.AccessoryFactory;
import Factory.Factories.BodyFactory;
import Factory.Factories.CarBuilder;
import Factory.Factories.MotorFactory;
import Factory.Suppliers.AccessorySupplier;
import Factory.Suppliers.BodySupplier;
import Factory.Suppliers.MotorSupplier;
import Factory.View.GUI;
import Factory.Warehouses.*;
import ThreadPool.ThreadPool;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        GUI gui = new GUI();
        gui.setVisible(true);

        InputStream inputStream = Main.class.getResourceAsStream("configuration.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        int bodyWarehouseSize = Integer.parseInt(properties.getProperty("BodyWarehouseSize"));
        int motorWarehouseSize = Integer.parseInt(properties.getProperty("MotorWarehouseSize"));
        int accessoryWarehouseSize = Integer.parseInt(properties.getProperty("AccessoryWarehouseSize"));
        int carWarehouseSize = Integer.parseInt(properties.getProperty("CarWarehouseSize"));
        int accessorySuppliersCount = Integer.parseInt(properties.getProperty("AccessorySuppliers"));
        int workersCount = Integer.parseInt(properties.getProperty("Workers"));
        int dealersCount = Integer.parseInt(properties.getProperty("Dealers"));

        BodyFactory bodyFactory = new BodyFactory();
        MotorFactory motorFactory = new MotorFactory();
        AccessoryFactory accessoryFactory = new AccessoryFactory();
        CarBuilder carBuilder = new CarBuilder();

        BodyWarehouse bodyWarehouse = new BodyWarehouse(bodyWarehouseSize);
        MotorWarehouse motorWarehouse = new MotorWarehouse(motorWarehouseSize);
        AccessoryWarehouse accessoryWarehouse = new AccessoryWarehouse(accessoryWarehouseSize);
        CarWarehouse carWarehouse = new CarWarehouse(carWarehouseSize);

        BodySupplier bodySupplier = new BodySupplier(bodyWarehouse, bodyFactory, 1000);
        MotorSupplier motorSupplier = new MotorSupplier(motorWarehouse, motorFactory, 1000);
        ArrayList<AccessorySupplier> accessorySuppliers = new ArrayList<>();
        for (int i = 0; i < accessorySuppliersCount; ++i) {
            accessorySuppliers.add(new AccessorySupplier(accessoryWarehouse, accessoryFactory, 1000));
        }
        bodySupplier.start();
        motorSupplier.start();
        for (AccessorySupplier accessorySupplier : accessorySuppliers) {
            accessorySupplier.start();
        }

        ThreadPool threadPool = new ThreadPool(workersCount);
        for (int i = 0; i < workersCount; ++i) {
            threadPool.addTask(new Worker("Worker" + i, bodyWarehouse, motorWarehouse, accessoryWarehouse, carBuilder, carWarehouse, 1000));
        }

        ArrayList<Dealer> dealers = new ArrayList<>();
        for (int i = 0; i < dealersCount; ++i) {
            dealers.add(new Dealer("Dealer" + i, carWarehouse, 5000));
        }
        for (Dealer dealer : dealers) {
            dealer.start();
        }
    }
}
package Factory.General;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private final int bodyWarehouseSize;
    private final int motorWarehouseSize;
    private final int accessoryWarehouseSize;
    private final int carWarehouseSize;
    private final int accessorySuppliersCount;
    private final int workersCount;
    private final int dealersCount;
    private final boolean logSale;

    public Configuration() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = Configuration.class.getClassLoader().getResourceAsStream("configuration.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        bodyWarehouseSize = Integer.parseInt(properties.getProperty("BodyWarehouseSize"));
        motorWarehouseSize = Integer.parseInt(properties.getProperty("MotorWarehouseSize"));
        accessoryWarehouseSize = Integer.parseInt(properties.getProperty("AccessoryWarehouseSize"));
        carWarehouseSize = Integer.parseInt(properties.getProperty("CarWarehouseSize"));
        accessorySuppliersCount = Integer.parseInt(properties.getProperty("AccessorySuppliers"));
        workersCount = Integer.parseInt(properties.getProperty("Workers"));
        dealersCount = Integer.parseInt(properties.getProperty("Dealers"));
        logSale = Boolean.parseBoolean(properties.getProperty("LogSale"));
    }

    public int getAllWorkersCount() {
        return workersCount + dealersCount + accessorySuppliersCount + 2;
    }

    public int getBodyWarehouseSize() {
        return bodyWarehouseSize;
    }

    public int getMotorWarehouseSize() {
        return motorWarehouseSize;
    }

    public int getAccessoryWarehouseSize() {
        return accessoryWarehouseSize;
    }

    public int getCarWarehouseSize() {
        return carWarehouseSize;
    }

    public int getAccessorySuppliersCount() {
        return accessorySuppliersCount;
    }

    public int getWorkersCount() {
        return workersCount;
    }

    public int getDealersCount() {
        return dealersCount;
    }

    public boolean isLogSale() {
        return logSale;
    }
}

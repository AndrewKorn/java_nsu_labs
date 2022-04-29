import Factory.Workers.AccessorySuppliers;
import Factory.Workers.Dealers;
import Factory.Factories.AllFactories;
import Factory.General.Configuration;
import Factory.Products.Body;
import Factory.Products.Motor;
import Factory.View.GUI;
import Factory.ProductsCounters.AllProductsCounters;
import Factory.Warehouses.AllWarehouses;
import ThreadPool.TasksList;
import Factory.Workers.Supplier;
import Factory.Workers.Workers;
import ThreadPool.ThreadPool;
import ThreadPool.Task;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        AllFactories allFactories = new AllFactories();
        AllProductsCounters productsCounters = new AllProductsCounters();
        AllWarehouses allWarehouses = new AllWarehouses(configuration);

        Supplier<Body> bodySupplier = new Supplier<>(
                allWarehouses.getBodyWarehouse(),
                allFactories.getBodyFactory(),
                productsCounters.getReleasedBodyCounter(),
                1000
        );

        Supplier<Motor> motorSupplier = new Supplier<>(
                allWarehouses.getMotorWarehouse(),
                allFactories.getMotorFactory(),
                productsCounters.getReleasedMotorCounter(),
                1000
        );

        AccessorySuppliers accessorySuppliers = new AccessorySuppliers(configuration.getAccessorySuppliersCount(), allWarehouses, allFactories, productsCounters);
        Dealers dealers = new Dealers(configuration.getDealersCount(), allWarehouses, allFactories, productsCounters);
        Workers workers = new Workers(configuration.getWorkersCount(), allWarehouses, allFactories, productsCounters);
        TasksList tasksList = new TasksList(bodySupplier, motorSupplier, accessorySuppliers, dealers, workers);

        ThreadPool threadPool = new ThreadPool(configuration.getAllWorkersCount());
        for (Task task : tasksList.getTasks()) {
            threadPool.addTask(task);
        }

        GUI gui = new GUI(allWarehouses, productsCounters, bodySupplier, motorSupplier, accessorySuppliers, dealers);
        gui.setVisible(true);
    }
}
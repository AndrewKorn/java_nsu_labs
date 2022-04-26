package Factory;

import Factory.Factories.AllFactories;
import Factory.General.Configuration;
import Factory.Workers.Suppliers.AccessorySupplier;
import Factory.Workers.Suppliers.BodySupplier;
import Factory.Workers.Suppliers.MotorSupplier;
import Factory.Warehouses.AllWarehouses;
import Factory.Workers.Dealer;
import Factory.Workers.Worker;
import ThreadPool.Task;

import java.util.ArrayList;

public class TasksList {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public TasksList(Configuration configuration, AllFactories allFactories, AllWarehouses allWarehouses) {
        tasks.add(new BodySupplier(allWarehouses.getBodyWarehouse(), allFactories.getBodyFactory(), 100));
        tasks.add(new MotorSupplier(allWarehouses.getMotorWarehouse(), allFactories.getMotorFactory(), 500));

        for (int i = 0; i < configuration.getAccessorySuppliersCount(); ++i) {
            tasks.add(new AccessorySupplier(
                    allWarehouses.getAccessoryWarehouse(),
                    allFactories.getAccessoryFactory(),
                    1000)
            );
        }

        for (int i = 0; i < configuration.getWorkersCount(); ++i) {
            tasks.add(new Worker(
                    "Worker" + i,
                    allWarehouses.getBodyWarehouse(),
                    allWarehouses.getMotorWarehouse(),
                    allWarehouses.getAccessoryWarehouse(),
                    allFactories.getCarBuilder(),
                    allWarehouses.getCarWarehouse())
            );
        }

        for (int i = 0; i < configuration.getDealersCount(); ++i) {
            tasks.add(new Dealer(
                    "Dealer" + i,
                    allWarehouses.getCarWarehouse(),
                    10000)
            );
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}

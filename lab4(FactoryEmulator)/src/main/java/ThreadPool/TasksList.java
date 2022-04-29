package ThreadPool;

import Factory.Factories.AllFactories;
import Factory.General.Configuration;
import Factory.Products.Body;
import Factory.Products.Motor;
import Factory.Workers.*;

import java.util.ArrayList;

public class TasksList {
    private final ArrayList<Task> tasks = new ArrayList<>();


    public TasksList(
                     Supplier<Body> bodySupplier,
                     Supplier<Motor> motorSupplier,
                     AccessorySuppliers accessorySuppliers,
                     Dealers dealers,
                     Workers workers
    ) {
        tasks.add(bodySupplier);
        tasks.add(motorSupplier);
        tasks.addAll(accessorySuppliers.getAccessorySuppliers());
        tasks.addAll(workers.getWorkers());
        tasks.addAll(dealers.getDealers());

    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}

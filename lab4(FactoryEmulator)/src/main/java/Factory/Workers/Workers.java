package Factory.Workers;

import Factory.ProductsCounters.AllProductsCounters;
import Factory.Factories.AllFactories;
import Factory.Warehouses.AllWarehouses;

import java.util.ArrayList;

public class Workers {
    private final ArrayList<Worker> workers = new ArrayList<>();

    public Workers(int workersCount, AllWarehouses allWarehouses, AllFactories allFactories, AllProductsCounters allProductsCounters) {
        for (int i = 0; i < workersCount; ++i) {
            workers.add(new Worker(
                    "Worker" + i,
                    allWarehouses.getBodyWarehouse(),
                    allWarehouses.getMotorWarehouse(),
                    allWarehouses.getAccessoryWarehouse(),
                    allFactories.getCarBuilder(),
                    allWarehouses.getCarWarehouse(),
                    allProductsCounters.getReleasedCarCounter()
                    )
            );
        }
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }
}

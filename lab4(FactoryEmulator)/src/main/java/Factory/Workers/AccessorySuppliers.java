package Factory.Workers;

import Factory.ProductsCounters.AllProductsCounters;
import Factory.Factories.AllFactories;
import Factory.Products.Accessory;
import Factory.Warehouses.AllWarehouses;

import java.util.ArrayList;

public class AccessorySuppliers {
    private final ArrayList<Supplier<Accessory>> accessorySuppliers = new ArrayList<>();

    public AccessorySuppliers(int accessorySuppliersCount, AllWarehouses allWarehouses, AllFactories allFactories, AllProductsCounters allProductsCounters) {
        for (int i = 0; i < accessorySuppliersCount; ++i) {
            accessorySuppliers.add(new Supplier<>(
                    allWarehouses.getAccessoryWarehouse(),
                    allFactories.getAccessoryFactory(),
                    allProductsCounters.getReleasedAccessoryCounter(),
                    1000)
            );
        }
    }

    public void setWaitTime(int waitTime) {
        for (Supplier<Accessory> supplier : accessorySuppliers) {
            supplier.setWaitTime(waitTime);
        }
    }

    public ArrayList<Supplier<Accessory>> getAccessorySuppliers() {
        return accessorySuppliers;
    }
}

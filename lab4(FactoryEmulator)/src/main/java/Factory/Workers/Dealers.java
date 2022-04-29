package Factory.Workers;

import Factory.ProductsCounters.AllProductsCounters;
import Factory.Factories.AllFactories;
import Factory.Warehouses.AllWarehouses;

import java.util.ArrayList;

public class Dealers {
    private final ArrayList<Dealer> dealers = new ArrayList<>();

    public Dealers(int dealersCount, AllWarehouses allWarehouses, AllFactories allFactories, AllProductsCounters allProductsCounters) {
        for (int i = 0; i < dealersCount; ++i) {
            dealers.add(new Dealer(
                        "Dealer" + i,
                        allWarehouses.getCarWarehouse(),
                        allProductsCounters.getCarsSoldCounter(),
                        1000
                    )
            );
        }
    }

    public void setWaitTime(int waitTime) {
        for (Dealer dealer : dealers) {
            dealer.setWaitTime(waitTime);
        }
    }

    public ArrayList<Dealer> getDealers() {
        return dealers;
    }
}

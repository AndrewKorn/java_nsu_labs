package Factory.View;

import Factory.General.Subscriber;
import Factory.Warehouses.ConcreteWarehouse;
import Factory.ProductsCounters.ProductsCounter;

import javax.swing.*;

public class ConcreteInfoPanel extends JPanel implements Subscriber {
    private final String name;
    private final JLabel warehouseCountLabel;
    private final JLabel producedCountLabel;
    private final ConcreteWarehouse<?> warehouse;
    private final ProductsCounter<?> productsCounter;

    public ConcreteInfoPanel(String name, ConcreteWarehouse<?> warehouse, ProductsCounter<?> productsCounter) {
        super();
        this.name = name;
        warehouseCountLabel = new JLabel("|  " + name + " warehouse count: 0  |  ");
        producedCountLabel = new JLabel(name + " produced count: 0  |");
        this.warehouse = warehouse;
        this.productsCounter = productsCounter;
        this.add(warehouseCountLabel);
        this.add(producedCountLabel);

    }

    @Override
    public void reactOnNotify() {
        warehouseCountLabel.setText("|  " + name + " warehouse count: " + warehouse.getCount() + "  |  ");
        producedCountLabel.setText(name + " produced count: " + productsCounter.getCount() + "  |");
    }
}

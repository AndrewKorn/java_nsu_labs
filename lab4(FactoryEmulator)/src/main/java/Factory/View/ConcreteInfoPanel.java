package Factory.View;

import Factory.General.Subscriber;
import Factory.Warehouses.ConcreteWarehouse;

import javax.swing.*;

public class ConcreteInfoPanel extends JPanel implements Subscriber {
    private final String name;
    private final JLabel warehouseCountLabel;
    private final JLabel producedCountLabel;
    private final ConcreteWarehouse<?> warehouse;

    public ConcreteInfoPanel(String name, ConcreteWarehouse<?> warehouse) {
        super();
        this.name = name;
        warehouseCountLabel = new JLabel(name + " warehouse count: 0");
        producedCountLabel = new JLabel(name + " produced count: 0");
        this.warehouse = warehouse;
        this.add(warehouseCountLabel);
        this.add(producedCountLabel);
    }

    @Override
    public void reactOnNotify() {
        warehouseCountLabel.setText(name + " warehouse count: " + warehouse.getCount());
        producedCountLabel.setText(name + " produced count: ");
    }
}

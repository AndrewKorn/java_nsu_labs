package Factory.View;

import Factory.Warehouses.AllProductsCounters;
import Factory.Warehouses.AllWarehouses;
import Factory.General.Subscriber;


import javax.swing.*;

public class InfoPanel extends JPanel implements Subscriber {
    private final ConcreteInfoPanel bodyInfoPanel;
    private final ConcreteInfoPanel motorInfoPanel;
    private final ConcreteInfoPanel accessoryInfoPanel;
    private final ConcreteInfoPanel carInfoPanel;
    private final DealerInfoPanel dealerInfoPanel;

    public InfoPanel(AllWarehouses allWarehouses, AllProductsCounters productsCounters) {
        super();
        bodyInfoPanel = new ConcreteInfoPanel("Body", allWarehouses.getBodyWarehouse(), productsCounters.getReleasedBodyCounter());
        motorInfoPanel = new ConcreteInfoPanel("Motor", allWarehouses.getMotorWarehouse(), productsCounters.getReleasedMotorCounter());
        accessoryInfoPanel = new ConcreteInfoPanel("Accessory", allWarehouses.getAccessoryWarehouse(), productsCounters.getReleasedAccessoryCounter());
        carInfoPanel = new ConcreteInfoPanel("Car", allWarehouses.getCarWarehouse(), productsCounters.getReleasedCarCounter());
        dealerInfoPanel = new DealerInfoPanel(productsCounters.getCarsSoldCounter());

        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(bodyInfoPanel);
        this.add(motorInfoPanel);
        this.add(accessoryInfoPanel);
        this.add(carInfoPanel);
        this.add(dealerInfoPanel);
    }

    @Override
    public void reactOnNotify() {
        bodyInfoPanel.reactOnNotify();
        motorInfoPanel.reactOnNotify();
        accessoryInfoPanel.reactOnNotify();
        carInfoPanel.reactOnNotify();
        dealerInfoPanel.reactOnNotify();
    }
}

package Factory.View;

import Factory.Warehouses.AllWarehouses;
import Factory.General.Subscriber;


import javax.swing.*;

public class InfoPanel extends JPanel implements Subscriber {
    private final ConcreteInfoPanel bodyInfoPanel;
    private final ConcreteInfoPanel motorInfoPanel;
    private final ConcreteInfoPanel accessoryInfoPanel;
    private final ConcreteInfoPanel carInfoPanel;

    public InfoPanel(AllWarehouses allWarehouses) {
        super();
        bodyInfoPanel = new ConcreteInfoPanel("Body", allWarehouses.getBodyWarehouse());
        motorInfoPanel = new ConcreteInfoPanel("Motor", allWarehouses.getMotorWarehouse());
        accessoryInfoPanel = new ConcreteInfoPanel("Accessory", allWarehouses.getAccessoryWarehouse());
        carInfoPanel = new ConcreteInfoPanel("Car", allWarehouses.getCarWarehouse());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(bodyInfoPanel);
        this.add(motorInfoPanel);
        this.add(accessoryInfoPanel);
        this.add(carInfoPanel);
    }

    @Override
    public void reactOnNotify() {
        bodyInfoPanel.reactOnNotify();
        motorInfoPanel.reactOnNotify();
        accessoryInfoPanel.reactOnNotify();
        carInfoPanel.reactOnNotify();
    }
}

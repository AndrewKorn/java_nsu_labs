package Factory.View;

import javax.swing.*;

public class SlidersPanel extends JPanel {
    public SlidersPanel() {
        super();
        JPanel bodySupplierPanel = new ConcreteSliderPanel("Body supplier wait time");
        JPanel motorSupplierPanel = new ConcreteSliderPanel("Motor supplier wait time");
        JPanel accessorySupplierPanel = new ConcreteSliderPanel("Accessory supplier wait time");
        JPanel dealerPanel = new ConcreteSliderPanel("Dealer wait time");

        this.add(bodySupplierPanel);
        this.add(motorSupplierPanel);
        this.add(accessorySupplierPanel);
        this.add(dealerPanel);
    }
}

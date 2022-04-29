package Factory.View;

import Factory.Workers.AccessorySuppliers;
import Factory.Workers.Dealers;
import Factory.Products.Body;
import Factory.Products.Motor;
import Factory.Workers.Supplier;

import javax.swing.*;

public class SlidersPanel extends JPanel {
    public SlidersPanel(Supplier<Body> bodySupplier, Supplier<Motor> motorSupplier, AccessorySuppliers accessorySuppliers, Dealers dealers) {
        super();
        JPanel bodySupplierPanel = new SupplierSliderPanel<>("Body supplier wait time", bodySupplier);
        JPanel motorSupplierPanel = new SupplierSliderPanel<>("Motor supplier wait time", motorSupplier);
        JPanel accessorySupplierPanel = new AccessorySupplierSliderPanel("Accessory supplier wait time", accessorySuppliers);
        JPanel dealerPanel = new DealersSliderPanel("Dealer wait time", dealers);

        this.add(bodySupplierPanel);
        this.add(motorSupplierPanel);
        this.add(accessorySupplierPanel);
        this.add(dealerPanel);
    }
}

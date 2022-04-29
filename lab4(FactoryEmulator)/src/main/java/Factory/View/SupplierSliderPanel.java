package Factory.View;

import Factory.Products.ConcreteProduct;
import Factory.Workers.Supplier;

import javax.swing.*;

public class SupplierSliderPanel<T extends ConcreteProduct> extends JPanel {
    public SupplierSliderPanel(String name, Supplier<T> supplier) {
        super();

        JSlider slider = new JSlider(0, 10, 1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);

        JLabel label = new JLabel(name + ": " + slider.getValue() + " seconds");

        slider.addChangeListener(e -> {
            int value = ((JSlider)e.getSource()).getValue();
            label.setText(name + ": " + value + " seconds");
            supplier.setWaitTime(value * 1000);
        });

        this.add(label);
        this.add(slider);
    }
}

package Factory.View;

import Factory.Workers.Dealers;

import javax.swing.*;

public class DealersSliderPanel extends JPanel {
    public DealersSliderPanel(String name, Dealers dealers) {
        super();

        JSlider slider = new JSlider(0, 10, 1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);

        JLabel label = new JLabel(name + ": " + slider.getValue() + " seconds");

        slider.addChangeListener(e -> {
            int value = ((JSlider)e.getSource()).getValue();
            label.setText(name + ": " + value + " seconds");
            dealers.setWaitTime(value * 1000);
        });

        this.add(label);
        this.add(slider);
    }
}

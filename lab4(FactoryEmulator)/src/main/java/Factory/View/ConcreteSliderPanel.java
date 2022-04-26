package Factory.View;

import javax.swing.*;

public class ConcreteSliderPanel extends JPanel {
    public ConcreteSliderPanel(String name) {
        super();

        JSlider slider = new JSlider(0, 5);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);

        JLabel label = new JLabel(name + ": " + slider.getValue() + " seconds");
        slider.addChangeListener(e -> {
            int value = ((JSlider)e.getSource()).getValue();
            label.setText(name + ": " + value + " seconds");

        });

        this.add(label);
        this.add(slider);
    }
}

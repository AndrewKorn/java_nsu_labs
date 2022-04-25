package Factory.View;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class GUI extends JFrame {
    public  GUI() {
        super("Car factory emulator");

        JSlider testSlider = new JSlider(0, 5000);
        testSlider.setMajorTickSpacing(1000);
        testSlider.setPaintTicks(true);

        JLabel label = new JLabel(getLabel(testSlider.getValue()));
        testSlider.addChangeListener(e -> {
            int value = ((JSlider)e.getSource()).getValue();
            label.setText(getLabel(value));
        });

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(testSlider);
        getContentPane().add(panel);
        this.setFocusable(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private String getLabel(int value) {
        return "Размер : " + value;
    }
}

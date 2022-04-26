package Factory.View;

import Factory.Warehouses.AllWarehouses;
import javax.swing.*;

public class GUI extends JFrame {
    public  GUI(AllWarehouses allWarehouses) {
        super("Car factory emulator");

        SlidersPanel slidersPanel = new SlidersPanel();


        InfoPanel infoPanel = new InfoPanel(allWarehouses);
        allWarehouses.addSubscriber(infoPanel);

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(slidersPanel);
        getContentPane().add(infoPanel);
        this.setFocusable(true);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

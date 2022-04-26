package Factory.View;

import Factory.Warehouses.AllProductsCounters;
import Factory.Warehouses.AllWarehouses;
import javax.swing.*;

public class GUI extends JFrame {
    public  GUI(AllWarehouses allWarehouses, AllProductsCounters productsCounters) {
        super("Car factory emulator");

        SlidersPanel slidersPanel = new SlidersPanel();

        InfoPanel infoPanel = new InfoPanel(allWarehouses, productsCounters);
        allWarehouses.addSubscriber(infoPanel);
        productsCounters.addSubscriber(infoPanel);

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

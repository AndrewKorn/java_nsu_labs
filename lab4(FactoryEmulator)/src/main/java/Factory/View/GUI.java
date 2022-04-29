package Factory.View;

import Factory.Workers.AccessorySuppliers;
import Factory.Workers.Dealers;
import Factory.Products.Body;
import Factory.Products.Motor;
import Factory.ProductsCounters.AllProductsCounters;
import Factory.Warehouses.AllWarehouses;
import Factory.Workers.Supplier;

import javax.swing.*;

public class GUI extends JFrame {
    public  GUI(AllWarehouses allWarehouses,
                AllProductsCounters productsCounters,
                Supplier<Body> bodySupplier,
                Supplier<Motor> motorSupplier,
                AccessorySuppliers accessorySuppliers,
                Dealers dealers
    ) {
        super("Car factory emulator");

        SlidersPanel slidersPanel = new SlidersPanel(bodySupplier, motorSupplier, accessorySuppliers, dealers);

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

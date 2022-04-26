package Factory.View;

import Factory.General.Subscriber;
import Factory.Products.Car;
import Factory.Warehouses.ProductsCounter;

import javax.swing.*;

public class DealerInfoPanel extends JPanel implements Subscriber  {
    ProductsCounter<Car> productsCounter;
    private final JLabel carsSoldLabel = new JLabel("Cars sold: 0");

    public DealerInfoPanel(ProductsCounter<Car> productsCounter) {
        super();
        this.productsCounter = productsCounter;
        this.add(carsSoldLabel);
    }

    @Override
    public void reactOnNotify() {
        carsSoldLabel.setText("Cars sold: " + productsCounter.getCount() + "  |");
    }
}

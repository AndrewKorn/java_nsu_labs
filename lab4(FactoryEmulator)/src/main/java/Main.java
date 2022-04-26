import Factory.Factories.AllFactories;
import Factory.General.Configuration;
import Factory.View.GUI;
import Factory.Warehouses.AllProductsCounters;
import Factory.Warehouses.AllWarehouses;
import Factory.TasksList;
import ThreadPool.ThreadPool;
import ThreadPool.Task;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        AllFactories allFactories = new AllFactories();
        AllProductsCounters productsCounters = new AllProductsCounters();
        AllWarehouses allWarehouses = new AllWarehouses(configuration);

        TasksList tasksList = new TasksList(configuration, allFactories, allWarehouses, productsCounters);
        ThreadPool threadPool = new ThreadPool(configuration.getAllWorkersCount());
        for (Task task : tasksList.getTasks()) {
            threadPool.addTask(task);
        }

        GUI gui = new GUI(allWarehouses, productsCounters);
        gui.setVisible(true);
    }
}
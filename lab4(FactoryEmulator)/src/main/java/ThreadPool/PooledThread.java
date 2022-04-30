package ThreadPool;

import Factory.General.FactoryLogger;

import java.util.List;
import java.util.logging.Level;

public class PooledThread extends Thread {
    private final List<Task> taskQueue;
    private final FactoryLogger logger;


    public PooledThread(String name, List<Task> taskQueue, FactoryLogger logger) {
        super(name);
        this.taskQueue = taskQueue;
        this.logger = logger;
    }


    public void run() {
        Task toExecute;
        while (true) {
            synchronized (taskQueue) {
                if (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    }
                    catch (InterruptedException e) {
                        logger.getExceptionMessage(Level.WARNING, e);
                    }
                    continue;
                }
                else {
                    toExecute = taskQueue.remove(0);
                }
            }
            try {
                toExecute.performWork();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

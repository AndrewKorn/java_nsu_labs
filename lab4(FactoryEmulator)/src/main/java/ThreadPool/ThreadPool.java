package ThreadPool;

import Factory.General.FactoryLogger;

import java.util.*;

public class ThreadPool{
    private final List<Task> taskQueue = new LinkedList<>();

    public void addTask(Task task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notify();
        }
    }

    public ThreadPool(int threadsCount, FactoryLogger logger) {
        Set<PooledThread> availableThreads = new HashSet<>();
        for (int i = 0; i < threadsCount; ++i) {
            availableThreads.add(new PooledThread("Performer " + i, taskQueue, logger));
        }
        for (PooledThread availableThread : availableThreads) {
            availableThread.start();
        }
    }
}

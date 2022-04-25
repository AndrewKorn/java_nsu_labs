package ThreadPool;

import java.util.*;

public class ThreadPool implements TaskListener {
    private final List<ThreadPoolTask> taskQueue = new LinkedList<>();

    @Override
    public void taskStarted(Task task)
    {
        System.out.println("Started:" + task.getName());
    }
    @Override
    public void taskFinished(Task task)
    {
        System.out.println("Finished:" + task.getName());
    }
    @Override
    public void taskInterrupted(Task task)
    {
        System.out.println("Interrupted:" + task.getName());
    }

    public void addTask(Task task, TaskListener taskListener) {
        synchronized (taskQueue) {
            taskQueue.add(new ThreadPoolTask(task, taskListener));
            taskQueue.notify();
        }
    }

    public void addTask(Task task) {
        addTask(task, this);
    }

    public ThreadPool(int threadsCount) {
        Set<PooledThread> availableThreads = new HashSet<>();
        for (int i = 0; i < threadsCount; ++i) {
            availableThreads.add(new PooledThread("Performer " + i, taskQueue));
        }
        for (PooledThread availableThread : availableThreads) {
            availableThread.start();
        }
    }
}

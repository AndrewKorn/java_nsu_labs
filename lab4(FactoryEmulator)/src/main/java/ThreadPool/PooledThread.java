package ThreadPool;

import java.util.List;

public class PooledThread extends Thread {
    private final List<ThreadPoolTask> taskQueue;

    public PooledThread(String name, List<ThreadPoolTask> taskQueue) {
        super(name);
        this.taskQueue = taskQueue;
    }

    private void performTask(ThreadPoolTask task) {
        task.prepare();
        try {
            task.go();
        }
        catch (InterruptedException e) {
            task.interrupted();
        }
        task.finish();
    }

    public void run() {
        ThreadPoolTask toExecute;
        while (true) {
            synchronized (taskQueue) {
                if (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    }
                    catch (InterruptedException e) {
                        System.err.println("Thread was interrupted:"+getName());
                    }
                    continue;
                }
                else {
                    toExecute = taskQueue.remove(0);
                }
            }
            System.out.println(getName() + " got the job: " + toExecute.getName());
            performTask(toExecute);
        }
    }
}

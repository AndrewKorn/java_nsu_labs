package ThreadPool;

public class ThreadPoolTask {
    private final Task task;
    private final TaskListener taskListener;

    public ThreadPoolTask(Task task, TaskListener taskListener) {
        this.task = task;
        this.taskListener = taskListener;
    }

    void prepare() {
        taskListener.taskStarted(task);
    }

    void finish() {
        taskListener.taskFinished(task);
    }

    void interrupted() {
        taskListener.taskInterrupted(task);
    }

    void go() throws InterruptedException {
        task.performWork();
    }

    String getName() {
        return task.getName();
    }
}

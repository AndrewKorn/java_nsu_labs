package ThreadPool;

public interface TaskListener {
    void taskStarted(Task task);
    void taskInterrupted(Task task);
    void taskFinished(Task task);
}

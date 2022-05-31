package Common;

public interface Publisher {
    void notifySubscribers();
    void addSubscriber(Subscriber subscriber);
    void deleteSubscriber(Subscriber subscriber);
}

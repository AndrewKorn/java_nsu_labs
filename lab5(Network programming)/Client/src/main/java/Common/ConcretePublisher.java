package Common;

import java.util.ArrayList;
import java.util.List;

public class ConcretePublisher implements Publisher {
    private final List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.reactOnNotify();
        }
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void deleteSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }
}

package com;

import java.util.concurrent.CopyOnWriteArrayList;

public class ConcretePublisher implements Publisher {
    CopyOnWriteArrayList<Subscriber> subscribers = new CopyOnWriteArrayList<>();

    @Override
    public void notifySubscriber() {
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

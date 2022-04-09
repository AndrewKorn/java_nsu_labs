package com.general;

public interface Publisher {
    void notifySubscriber();
    void addSubscriber(Subscriber subscriber);
    void deleteSubscriber(Subscriber subscriber);
}

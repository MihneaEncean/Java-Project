package repository;

import model.Subscriber;

import java.util.ArrayList;
import java.util.Collection;

public class SubscriberRepository {
    private Collection<Subscriber> subscribers;

    public SubscriberRepository() {
        this.subscribers = new ArrayList<>();
    }

    public Collection<Subscriber> getAll() {
        return subscribers;
    }

    public void add(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public Subscriber getByName(String subscriberName) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getName().equals(subscriberName)) {
                return subscriber;
            }
        }
        return null;
    }
}

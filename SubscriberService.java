package service;

import model.Subscriber;
import model.SubscriberTypes;
import repository.SubscriberRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

public class SubscriberService {
    private final SubscriberRepository subscriberRepository;

    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
        generateSubscribers();
    }

    private void generateSubscribers() {
        for (int i = 0; i < 50; ++i) {
            int leftLimit = 97;
            int rightLimit = 122;
            int targetStringLength = 10;
            Random random = new Random();
            StringBuilder bufferName = new StringBuilder(targetStringLength);
            for (int j = 0; j < targetStringLength; j++) {
                int randomLimitedIntTitle = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                bufferName.append((char) randomLimitedIntTitle);
            }
            this.addSubscriber(new Subscriber(bufferName.toString(), (int) ((Math.random() * (500 - 100)) + 100),
                    Arrays.stream(SubscriberTypes.values()).collect(Collectors.toList())
                            .get(random.nextInt(2)).toString()));
        }
    }

    private void addSubscriber(Subscriber subscriber) {
        this.subscriberRepository.add(subscriber);
    }

    public Collection<Subscriber> getAll() { return subscriberRepository.getAll();}

}

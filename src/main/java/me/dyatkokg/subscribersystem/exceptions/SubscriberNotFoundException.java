package me.dyatkokg.subscribersystem.exceptions;

public class SubscriberNotFoundException extends RuntimeException {

    public SubscriberNotFoundException(Long id) {
        super(String.format("Subscriber with id %s was not found", id));
    }

    public SubscriberNotFoundException() {
        super("Subscriber was not found");
    }

}

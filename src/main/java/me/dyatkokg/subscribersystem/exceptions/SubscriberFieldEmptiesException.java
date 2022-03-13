package me.dyatkokg.subscribersystem.exceptions;

public class SubscriberFieldEmptiesException extends RuntimeException {

    public SubscriberFieldEmptiesException() {
        super("Field firstName and lastName cannot be empty");
    }
}

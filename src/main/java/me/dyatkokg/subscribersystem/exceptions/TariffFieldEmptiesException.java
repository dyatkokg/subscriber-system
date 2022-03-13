package me.dyatkokg.subscribersystem.exceptions;

public class TariffFieldEmptiesException extends RuntimeException {

    public TariffFieldEmptiesException() {
        super("Field name and price cannot be empty");
    }
}

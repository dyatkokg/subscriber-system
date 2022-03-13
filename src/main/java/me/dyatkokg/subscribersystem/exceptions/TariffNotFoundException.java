package me.dyatkokg.subscribersystem.exceptions;

public class TariffNotFoundException extends RuntimeException {

    public TariffNotFoundException(Long id) {
        super(String.format("Tariff with id %s was not found", id));
    }

    public TariffNotFoundException() {
        super("Tariff was not found");
    }
}

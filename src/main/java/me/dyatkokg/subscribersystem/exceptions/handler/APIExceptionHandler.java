package me.dyatkokg.subscribersystem.exceptions.handler;

import lombok.extern.slf4j.Slf4j;
import me.dyatkokg.subscribersystem.exceptions.SubscriberFieldEmptiesException;
import me.dyatkokg.subscribersystem.exceptions.SubscriberNotFoundException;
import me.dyatkokg.subscribersystem.exceptions.TariffFieldEmptiesException;
import me.dyatkokg.subscribersystem.exceptions.TariffNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class APIExceptionHandler {


    @ExceptionHandler({SubscriberNotFoundException.class})
    public ResponseEntity<Object> handleSubscriberNotFound(SubscriberNotFoundException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler({TariffNotFoundException.class})
    public ResponseEntity<Object> handleTariffNotFound(TariffNotFoundException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler({SubscriberFieldEmptiesException.class})
    public ResponseEntity<Object> handleSubscriberFieldEmpty(SubscriberFieldEmptiesException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler({TariffFieldEmptiesException.class})
    public ResponseEntity<Object> handleTariffFieldEmpty(TariffFieldEmptiesException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.badRequest().build();
    }
}


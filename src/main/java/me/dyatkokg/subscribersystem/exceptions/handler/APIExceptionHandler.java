package me.dyatkokg.subscribersystem.exceptions.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dyatkokg.subscribersystem.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIExceptionHandler {

    private APIExceptions exceptions = new APIExceptions();

    @ExceptionHandler(SubscriberNotFoundException.class)
    public ResponseEntity<APIExceptions> handleSubscriberNotFound(SubscriberNotFoundException e) {
        log.error(e.getMessage());
        exceptions.setMessage(" exception: " + e.getMessage());
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(exceptions, status);
    }

    @ExceptionHandler({TariffNotFoundException.class})
    public ResponseEntity<Object> handleTariffNotFound(TariffNotFoundException e) {
        log.error(e.getMessage());
        exceptions.setMessage(" exception: " + e.getMessage());
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(exceptions, status);
    }

    @ExceptionHandler({SubscriberFieldEmptiesException.class})
    public ResponseEntity<Object> handleSubscriberFieldEmpty(SubscriberFieldEmptiesException e) {
        log.error(e.getMessage());
        exceptions.setMessage(" exception: " + e.getMessage());
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(exceptions, status);
    }

    @ExceptionHandler({TariffFieldEmptiesException.class})
    public ResponseEntity<Object> handleTariffFieldEmpty(TariffFieldEmptiesException e) {
        log.error(e.getMessage());
        exceptions.setMessage(" exception: " + e.getMessage());
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(exceptions, status);
    }
}


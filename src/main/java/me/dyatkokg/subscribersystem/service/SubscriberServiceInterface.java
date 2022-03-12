package me.dyatkokg.subscribersystem.service;

import me.dyatkokg.subscribersystem.entity.Subscriber;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface SubscriberServiceInterface {

    ResponseEntity<Subscriber> create(Subscriber subscriber);

    Page<Subscriber> findAll(int page, int size);

    ResponseEntity<Subscriber> deleteById(Long id);

    ResponseEntity<Subscriber> update(Subscriber subscriber);

    ResponseEntity<Subscriber> getById(Long id);
}

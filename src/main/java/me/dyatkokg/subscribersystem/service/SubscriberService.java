package me.dyatkokg.subscribersystem.service;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.subscribersystem.entity.Balance;
import me.dyatkokg.subscribersystem.entity.Subscriber;
import me.dyatkokg.subscribersystem.entity.Tariff;
import me.dyatkokg.subscribersystem.repository.SubscriberRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class SubscriberService implements SubscriberServiceInterface {

    private final SubscriberRepository subscriberRepository;

    @Override
    public ResponseEntity<Subscriber> create(Subscriber subscriber) {
        return ResponseEntity.ok(subscriberRepository.save(subscriber));
    }

    @Override
    public Page<Subscriber> findAll(int page, int size) {
        return subscriberRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public ResponseEntity<Subscriber> deleteById(Long id) {
        Subscriber deleted = subscriberRepository.findById(id).orElse(null);
        if (deleted == null) {
            return ResponseEntity.noContent().build();
        } else
            subscriberRepository.delete(deleted);
        return ResponseEntity.ok(deleted);
    }

    @Override
    public ResponseEntity<Subscriber> update(Subscriber subscriber) {
        if (subscriberRepository.existsById(subscriber.getId())) {
            return ResponseEntity.ok(subscriberRepository.save(subscriber));
        } else
            return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Subscriber> getById(Long id) {
        return subscriberRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}

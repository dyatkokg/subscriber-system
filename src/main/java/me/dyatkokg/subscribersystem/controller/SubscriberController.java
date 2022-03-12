package me.dyatkokg.subscribersystem.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.subscribersystem.entity.Subscriber;
import me.dyatkokg.subscribersystem.service.SubscriberService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subscribers")
@RequiredArgsConstructor
public class SubscriberController {

    private final SubscriberService subscriberService;

    @PutMapping("create")
    public ResponseEntity<Subscriber> create(@RequestBody Subscriber subscriber) {
        return subscriberService.create(subscriber);
    }

    @GetMapping("all")
    public Page<Subscriber> findAll(@RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                   @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return subscriberService.findAll(page, size);
    }

    @GetMapping("{id}")
    public ResponseEntity<Subscriber> getById(@PathVariable("id") Long id) {
        return subscriberService.getById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Subscriber> deleteById(@PathVariable("id") Long id) {
        return subscriberService.deleteById(id);
    }

    @PostMapping("update")
    public ResponseEntity<Subscriber> update(@RequestBody Subscriber subscriber) {
        return subscriberService.update(subscriber);
    }

}

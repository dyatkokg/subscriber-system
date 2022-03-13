package me.dyatkokg.subscribersystem.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.subscribersystem.dto.SubscriberDTO;
import me.dyatkokg.subscribersystem.service.implementation.SubscriberService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subscribers")
@RequiredArgsConstructor
public class SubscriberController {

    private final SubscriberService subscriberService;

    @PutMapping("create")
    public ResponseEntity<SubscriberDTO> create(@RequestBody SubscriberDTO subscriberDTO) {
        return subscriberService.create(subscriberDTO);
    }

    @GetMapping("all")
    public Page<SubscriberDTO> findAll(@RequestParam(value = "size", required = false, defaultValue = "10") int size,
                                       @RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        return subscriberService.findAll(page, size);
    }

    @GetMapping("{id}")
    public ResponseEntity<SubscriberDTO> getById(@PathVariable("id") Long id) {
        return subscriberService.getById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SubscriberDTO> deleteById(@PathVariable("id") Long id) {
        return subscriberService.deleteById(id);
    }

    @PostMapping("update")
    public ResponseEntity<SubscriberDTO> update(@RequestBody SubscriberDTO subscriberDTO) {
        return subscriberService.update(subscriberDTO);
    }

}

package me.dyatkokg.subscribersystem.service;

import me.dyatkokg.subscribersystem.dto.SubscriberDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface SubscriberServiceInterface {

    Page<SubscriberDTO> findAll(int page, int size);

    ResponseEntity<SubscriberDTO> deleteById(Long id);

    ResponseEntity<SubscriberDTO> update(SubscriberDTO subscriberDTO);

    ResponseEntity<SubscriberDTO> getById(Long id);
}

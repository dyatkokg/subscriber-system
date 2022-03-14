package me.dyatkokg.subscribersystem.service.implementation;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.subscribersystem.dto.SubscriberDTO;
import me.dyatkokg.subscribersystem.entity.Balance;
import me.dyatkokg.subscribersystem.entity.Subscriber;
import me.dyatkokg.subscribersystem.entity.Tariff;
import me.dyatkokg.subscribersystem.exceptions.SubscriberFieldEmptiesException;
import me.dyatkokg.subscribersystem.exceptions.SubscriberNotFoundException;
import me.dyatkokg.subscribersystem.exceptions.TariffNotFoundException;
import me.dyatkokg.subscribersystem.mapper.SubscriberMapper;
import me.dyatkokg.subscribersystem.repository.SubscriberRepository;
import me.dyatkokg.subscribersystem.repository.TariffRepository;
import me.dyatkokg.subscribersystem.service.SubscriberServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SubscriberService implements SubscriberServiceInterface {

    private final SubscriberRepository subscriberRepository;
    private final SubscriberMapper mapper;
    private final TariffRepository tariffRepository;

    @Override
    public Page<SubscriberDTO> findAll(int page, int size) {
        return subscriberRepository.findAll(PageRequest.of(page, size)).map(mapper::toDTO);
    }

    @Override
    public ResponseEntity<SubscriberDTO> deleteById(Long id) {
        SubscriberDTO deleted = subscriberRepository.findById(id).map(mapper::toDTO).orElseThrow(SubscriberNotFoundException::new);
        if (deleted == null) {
            throw new SubscriberNotFoundException();
        } else
            subscriberRepository.deleteById(id);
        return ResponseEntity.ok(deleted);
    }

    @Override
    public ResponseEntity<SubscriberDTO> getById(Long id) {
        return subscriberRepository.findById(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new SubscriberNotFoundException(id));
    }

    public ResponseEntity<SubscriberDTO> update(SubscriberDTO subscriberDTO) {
        if (Objects.nonNull(subscriberDTO.getFirstName()) && Objects.nonNull(subscriberDTO.getLastName())) {
            Subscriber subscriber;
            if (Objects.nonNull(subscriberDTO.getId())) {
                subscriber = subscriberRepository.findById(subscriberDTO.getId()).orElseThrow(SubscriberNotFoundException::new);
                subscriber.setFirstName(subscriberDTO.getFirstName());
                subscriber.setLastName(subscriberDTO.getLastName());
            } else {
                subscriber = mapper.toEntity(subscriberDTO);
            }
            if (Objects.nonNull(subscriberDTO.getTariff())) {
                Tariff tariff = tariffRepository.findByName(subscriberDTO.getTariff()).orElseThrow(TariffNotFoundException::new);
                Balance balance = new Balance();
                balance.setTariff(tariff);
                balance.setBalance(tariff.getPrice());
                subscriber.setSubscriberBalance(balance);
            }
            return ResponseEntity.ok(mapper.toDTO(subscriberRepository.save(subscriber)));
        } else throw new SubscriberFieldEmptiesException();
    }
}

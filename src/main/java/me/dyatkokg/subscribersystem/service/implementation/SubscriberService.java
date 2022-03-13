package me.dyatkokg.subscribersystem.service.implementation;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.subscribersystem.dto.SubscriberDTO;
import me.dyatkokg.subscribersystem.entity.Balance;
import me.dyatkokg.subscribersystem.entity.Subscriber;
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
    public ResponseEntity<SubscriberDTO> create(SubscriberDTO subscriberDTO) {
        if (Objects.nonNull(subscriberDTO.getFirstName()) && Objects.nonNull(subscriberDTO.getLastName())) {
            Subscriber subscriber;
            subscriber = mapper.toEntity(subscriberDTO);
            Balance balance = subscriber.getSubscriberBalance();
            balance.setTariff(tariffRepository.findByName(subscriberDTO.getTariff()));
            balance.setBalance(subscriberDTO.getBalance());
            subscriber.setSubscriberBalance(balance);
            if (Objects.nonNull(tariffRepository.findByName(subscriberDTO.getTariff()))) {
                return ResponseEntity.ok(mapper.toDTO(subscriberRepository.save(subscriber)));
            } else throw new TariffNotFoundException();
        } else throw new SubscriberFieldEmptiesException();
    }

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
    public ResponseEntity<SubscriberDTO> update(SubscriberDTO subscriberDTO) {
        if (subscriberRepository.existsById(subscriberDTO.getId())) {

            return ResponseEntity.ok(mapper.toDTO(subscriberRepository.save(mapper.toEntity(subscriberDTO))));
        } else throw new SubscriberNotFoundException();
    }

    @Override
    public ResponseEntity<SubscriberDTO> getById(Long id) {
        return subscriberRepository.findById(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new SubscriberNotFoundException(id));
    }


}

package me.dyatkokg.subscribersystem.service;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.subscribersystem.dto.SubscriberDTO;
import me.dyatkokg.subscribersystem.dto.TariffDTO;
import me.dyatkokg.subscribersystem.mapper.TariffMapper;
import me.dyatkokg.subscribersystem.repository.TariffRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TariffService implements TariffServiceInterface {

    private final TariffRepository tariffRepository;
    private final TariffMapper mapper;

    @Override
    public ResponseEntity<TariffDTO> create(TariffDTO tariffDTO) {
        return ResponseEntity.ok(mapper.toDTO(tariffRepository.save(mapper.toEntity(tariffDTO))));
    }

    @Override
    public ResponseEntity<TariffDTO> deleteById(Long id) {
        TariffDTO deleted = tariffRepository.findById(id).map(mapper::toDTO).orElse(null);
        if (deleted == null) {
            return ResponseEntity.noContent().build();
        } else
            tariffRepository.deleteById(id);
        return ResponseEntity.ok(deleted);
    }

    @Override
    public ResponseEntity<TariffDTO> update(TariffDTO tariffDTO) {
        if (tariffRepository.existsById(tariffDTO.getId())) {
            return ResponseEntity.ok(mapper.toDTO(tariffRepository.save(mapper.toEntity(tariffDTO))));
        } else
            return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<TariffDTO> getById(Long id) {
        return tariffRepository.findById(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<TariffDTO>> findAll() {
        return ResponseEntity.ok(tariffRepository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList()));
    }
}

package me.dyatkokg.subscribersystem.service.implementation;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.subscribersystem.dto.TariffDTO;
import me.dyatkokg.subscribersystem.entity.Tariff;
import me.dyatkokg.subscribersystem.exceptions.TariffFieldEmptiesException;
import me.dyatkokg.subscribersystem.exceptions.TariffNotFoundException;
import me.dyatkokg.subscribersystem.mapper.TariffMapper;
import me.dyatkokg.subscribersystem.repository.TariffRepository;
import me.dyatkokg.subscribersystem.service.TariffServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TariffService implements TariffServiceInterface {

    private final TariffRepository tariffRepository;
    private final TariffMapper mapper;

    @Override
    public ResponseEntity<TariffDTO> deleteById(Long id) {
        TariffDTO deleted = tariffRepository.findById(id).map(mapper::toDTO).orElseThrow(TariffNotFoundException::new);
        if (deleted == null) {
            throw new TariffNotFoundException();
        } else
            tariffRepository.deleteById(id);
        return ResponseEntity.ok(deleted);
    }

    @Override
    public ResponseEntity<TariffDTO> getById(Long id) {
        return tariffRepository.findById(id)
                .map(mapper::toDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new TariffNotFoundException(id));
    }

    public ResponseEntity<List<TariffDTO>> findAll() {
        return ResponseEntity.ok(tariffRepository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList()));
    }

    public ResponseEntity<TariffDTO> update(TariffDTO tariffDTO) {
        if (Objects.nonNull(tariffDTO.getName()) && Objects.nonNull(tariffDTO.getPrice())) {
            Tariff tariff;
            if (Objects.nonNull(tariffDTO.getId())) {
                tariff = tariffRepository.findById(tariffDTO.getId()).orElseThrow(TariffNotFoundException::new);
                tariff.setName(tariffDTO.getName());
                tariff.setPrice(tariffDTO.getPrice());
            } else {
                tariff = mapper.toEntity(tariffDTO);
            }
            return ResponseEntity.ok(mapper.toDTO(tariffRepository.save(tariff)));
        } else throw new TariffFieldEmptiesException();
    }
}

package me.dyatkokg.subscribersystem.service;

import me.dyatkokg.subscribersystem.dto.TariffDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TariffServiceInterface {

    ResponseEntity<TariffDTO> deleteById(Long id);

    ResponseEntity<TariffDTO> update(TariffDTO tariffDTO);

    ResponseEntity<TariffDTO> getById(Long id);

    ResponseEntity<List<TariffDTO>> findAll();
}

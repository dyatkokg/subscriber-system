package me.dyatkokg.subscribersystem.repository;

import me.dyatkokg.subscribersystem.dto.TariffDTO;
import me.dyatkokg.subscribersystem.entity.Tariff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TariffRepository extends CrudRepository<Tariff, Long> {

    List<Tariff> findAll();
}

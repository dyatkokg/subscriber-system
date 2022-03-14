package me.dyatkokg.subscribersystem.repository;

import me.dyatkokg.subscribersystem.entity.Tariff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface TariffRepository extends CrudRepository<Tariff, Long> {

    @NonNull
    List<Tariff> findAll();

   Optional<Tariff> findByName(String name);
}

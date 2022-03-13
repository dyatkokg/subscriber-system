package me.dyatkokg.subscribersystem.repository;

import me.dyatkokg.subscribersystem.entity.Tariff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface TariffRepository extends CrudRepository<Tariff, Long> {

    @NonNull
    List<Tariff> findAll();
}

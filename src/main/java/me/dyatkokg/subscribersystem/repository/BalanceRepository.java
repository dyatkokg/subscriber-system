package me.dyatkokg.subscribersystem.repository;

import me.dyatkokg.subscribersystem.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {

}

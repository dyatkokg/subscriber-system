package me.dyatkokg.subscribersystem.service.implementation;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.subscribersystem.dto.BalanceDTO;
import me.dyatkokg.subscribersystem.mapper.BalanceMapper;
import me.dyatkokg.subscribersystem.repository.BalanceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final BalanceRepository balanceRepository;
    private final BalanceMapper mapper;

    public ResponseEntity<List<BalanceDTO>> findAll() {
        return ResponseEntity.ok(balanceRepository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList()));
    }

}

package me.dyatkokg.subscribersystem.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.subscribersystem.dto.BalanceDTO;
import me.dyatkokg.subscribersystem.service.implementation.BalanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("balance")
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService service;

    @GetMapping("all")
    public ResponseEntity<List<BalanceDTO>> findAll() {
        return service.findAll();
    }

}

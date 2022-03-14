package me.dyatkokg.subscribersystem.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.subscribersystem.dto.TariffDTO;
import me.dyatkokg.subscribersystem.service.implementation.TariffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tariffs")
@RequiredArgsConstructor
public class TariffController {

    private final TariffService tariffService;

    @PutMapping("update")
    public ResponseEntity<TariffDTO> update(@RequestBody TariffDTO tariffDTO) {
        return tariffService.update(tariffDTO);
    }

    @GetMapping("all")
    public ResponseEntity<List<TariffDTO>> findAll() {
        return tariffService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<TariffDTO> getById(@PathVariable("id") Long id) {
        return tariffService.getById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TariffDTO> deleteById(@PathVariable("id") Long id) {
        return tariffService.deleteById(id);
    }

}

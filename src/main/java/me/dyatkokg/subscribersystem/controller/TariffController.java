package me.dyatkokg.subscribersystem.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.subscribersystem.dto.SubscriberDTO;
import me.dyatkokg.subscribersystem.dto.TariffDTO;
import me.dyatkokg.subscribersystem.service.TariffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tariffs")
@RequiredArgsConstructor
public class TariffController {

    private final TariffService tariffService;

    @PutMapping("create")
    public ResponseEntity<TariffDTO> create(@RequestBody TariffDTO tariffDTO) {
        return tariffService.create(tariffDTO);
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

    @PostMapping("update")
    public ResponseEntity<TariffDTO> update(@RequestBody TariffDTO tariffDTO) {
        return tariffService.update(tariffDTO);
    }

}

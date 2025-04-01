package com.retotecnicobackend.Controllers;

import com.retotecnicobackend.DTO.BusDTO;
import com.retotecnicobackend.Service.BusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public ResponseEntity<Page<BusDTO>> getAllBuses(Pageable pageable) {
        return ResponseEntity.ok(busService.getAllBuses(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusDTO> getBusById(@PathVariable Long id) {
        return ResponseEntity.ok(busService.getBusById(id));
    }

    @PostMapping
    public ResponseEntity<BusDTO> crearBus(@RequestBody BusDTO busDTO) {
        return ResponseEntity.ok(busService.crearBus(busDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusDTO> actualizarBus(
            @PathVariable Long id,
            @RequestBody BusDTO busDTO) {
        return ResponseEntity.ok(busService.actualizarBus(id, busDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBus(@PathVariable Long id) {
        busService.eliminarBus(id);
        return ResponseEntity.noContent().build();
    }
}
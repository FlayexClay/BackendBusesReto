package com.retotecnicobackend.Controllers;

import com.retotecnicobackend.DTO.MarcaBusDTO;
import com.retotecnicobackend.Service.MarcaBusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaBusController {
    private final MarcaBusService marcaBusService;

    public MarcaBusController(MarcaBusService marcaBusService) {
        this.marcaBusService = marcaBusService;
    }

    @GetMapping
    public ResponseEntity<List<MarcaBusDTO>> getAllMarcas() {
        return ResponseEntity.ok(marcaBusService.getAllMarcas());
    }

    @PostMapping
    public ResponseEntity<MarcaBusDTO> createMarca(@RequestBody MarcaBusDTO marcaBusDTO) {
        return ResponseEntity.ok(marcaBusService.createMarca(marcaBusDTO));
    }
}

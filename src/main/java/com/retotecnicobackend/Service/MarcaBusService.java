package com.retotecnicobackend.Service;

import com.retotecnicobackend.DTO.MarcaBusDTO;
import com.retotecnicobackend.Entity.MarcaBus;
import com.retotecnicobackend.Repository.MarcaBusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MarcaBusService {

    private final MarcaBusRepository marcaBusRepository;

    public MarcaBusService(MarcaBusRepository marcaBusRepository) {
        this.marcaBusRepository = marcaBusRepository;
    }

    // Métodos de conversión
    private MarcaBusDTO convertToDTO(MarcaBus marcaBus) {
        return new MarcaBusDTO(marcaBus.getId(), marcaBus.getNombre());
    }

    private MarcaBus convertToEntity(MarcaBusDTO marcaBusDTO) {
        MarcaBus marcaBus = new MarcaBus();
        marcaBus.setId(marcaBusDTO.getId());
        marcaBus.setNombre(marcaBusDTO.getNombre());
        return marcaBus;
    }

    // Obtener todas las marcas como DTOs
    public List<MarcaBusDTO> getAllMarcas() {
        return marcaBusRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Crear nueva marca desde DTO
    public MarcaBusDTO createMarca(MarcaBusDTO marcaBusDTO) {
        if (marcaBusRepository.existsByNombre(marcaBusDTO.getNombre())) {
            throw new RuntimeException("La marca ya existe");
        }

        MarcaBus nuevaMarca = convertToEntity(marcaBusDTO);
        MarcaBus marcaGuardada = marcaBusRepository.save(nuevaMarca);
        return convertToDTO(marcaGuardada);
    }

    // Método adicional para uso interno (si necesitas la entidad)
    protected MarcaBus getMarcaBusEntityById(Long id) {
        return marcaBusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));
    }
}
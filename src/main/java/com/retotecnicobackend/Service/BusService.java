package com.retotecnicobackend.Service;

import com.retotecnicobackend.DTO.BusDTO;
import com.retotecnicobackend.Entity.Bus;
import com.retotecnicobackend.Entity.MarcaBus;
import com.retotecnicobackend.Repository.BusRepository;
import com.retotecnicobackend.Repository.MarcaBusRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BusService {
    private final BusRepository busRepository;
    private final MarcaBusRepository marcaBusRepository;

    public BusService(BusRepository busRepository, MarcaBusRepository marcaBusRepository) {
        this.busRepository = busRepository;
        this.marcaBusRepository = marcaBusRepository;
    }

    // Métodos de conversión
    private Bus convertirDTOaEntity(BusDTO busDTO) {
        Bus bus = new Bus();
        bus.setId(busDTO.getId());
        bus.setNumeroBus(busDTO.getNumeroBus());
        bus.setPlaca(busDTO.getPlaca());
        bus.setCaracteristicas(busDTO.getCaracteristicas());
        bus.setActivo(busDTO.isActivo());

        // Buscar y asignar la marca
        MarcaBus marca = marcaBusRepository.findById(busDTO.getMarcaId())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada con id: " + busDTO.getMarcaId()));
        bus.setMarca(marca);

        return bus;
    }

    private BusDTO convertirEntityaDTO(Bus bus) {
        BusDTO busDTO = new BusDTO();
        busDTO.setId(bus.getId());
        busDTO.setNumeroBus(bus.getNumeroBus());
        busDTO.setPlaca(bus.getPlaca());
        busDTO.setFechaCreacion(bus.getFechaCreacion());
        busDTO.setCaracteristicas(bus.getCaracteristicas());
        busDTO.setMarcaId(bus.getMarca().getId());
        busDTO.setMarcaNombre(bus.getMarca().getNombre()); // Añade esta línea
        busDTO.setActivo(bus.isActivo());
        return busDTO;
    }

    // Métodos del servicio
    public Page<BusDTO> getAllBuses(Pageable pageable) {
        return busRepository.findAll(pageable)
                .map(this::convertirEntityaDTO);
    }

    public BusDTO getBusById(Long id) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus no encontrado con id: " + id));
        return convertirEntityaDTO(bus);
    }

    public BusDTO crearBus(BusDTO busDTO) {
        Bus bus = convertirDTOaEntity(busDTO);
        Bus busGuardado = busRepository.save(bus);
        return convertirEntityaDTO(busGuardado);
    }

    public BusDTO actualizarBus(Long id, BusDTO busDTO) {
        return busRepository.findById(id)
                .map(busExistente -> {
                    Bus busActualizado = convertirDTOaEntity(busDTO);
                    // Mantenemos los valores que no deben cambiar
                    busActualizado.setId(id);
                    busActualizado.setFechaCreacion(busExistente.getFechaCreacion());

                    Bus busGuardado = busRepository.save(busActualizado);
                    return convertirEntityaDTO(busGuardado);
                })
                .orElseThrow(() -> new RuntimeException("Bus no encontrado con id: " + id));
    }

    public void eliminarBus(Long id) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus no encontrado con id: " + id));
        busRepository.delete(bus);
    }
}
package com.retotecnicobackend.DTO;

import java.time.LocalDateTime;
import java.util.Objects;

public class BusDTO {
    private Long id;
    private String numeroBus;
    private String placa;
    private LocalDateTime fechaCreacion;
    private String caracteristicas;
    private Long marcaId;
    private String marcaNombre;
    private boolean activo;

    // Constructores
    public BusDTO() {
    }

    public BusDTO(Long id, String numeroBus, String placa, LocalDateTime fechaCreacion,
                  String caracteristicas, Long marcaId, String marcaNombre, boolean activo) {
        this.id = id;
        this.numeroBus = numeroBus;
        this.placa = placa;
        this.fechaCreacion = fechaCreacion;
        this.caracteristicas = caracteristicas;
        this.marcaId = marcaId;
        this.marcaNombre = marcaNombre;
        this.activo = activo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroBus() {
        return numeroBus;
    }

    public void setNumeroBus(String numeroBus) {
        this.numeroBus = numeroBus;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getMarcaNombre() {
        return marcaNombre;
    }

    public void setMarcaNombre(String marcaNombre) {
        this.marcaNombre = marcaNombre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusDTO busDTO = (BusDTO) o;
        return activo == busDTO.activo &&
                Objects.equals(id, busDTO.id) &&
                Objects.equals(numeroBus, busDTO.numeroBus) &&
                Objects.equals(placa, busDTO.placa) &&
                Objects.equals(fechaCreacion, busDTO.fechaCreacion) &&
                Objects.equals(caracteristicas, busDTO.caracteristicas) &&
                Objects.equals(marcaId, busDTO.marcaId) &&
                Objects.equals(marcaNombre, busDTO.marcaNombre); // Añadido
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroBus, placa, fechaCreacion,
                caracteristicas, marcaId, marcaNombre, activo); // Añadido marcaNombre
    }

    @Override
    public String toString() {
        return "BusDTO{" +
                "id=" + id +
                ", numeroBus='" + numeroBus + '\'' +
                ", placa='" + placa + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", marcaId=" + marcaId +
                ", marcaNombre='" + marcaNombre + '\'' + // Añadido
                ", activo=" + activo +
                '}';
    }
}
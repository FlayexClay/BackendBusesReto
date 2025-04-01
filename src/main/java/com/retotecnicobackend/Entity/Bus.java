package com.retotecnicobackend.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "buses")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroBus;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Column(nullable = false)
    private String caracteristicas;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private MarcaBus marca;

    @Column(nullable = false)
    private boolean activo;

    // Constructor vacío (JPA requiere esto)
    public Bus() {}

    // Constructor con parámetros
    public Bus(Long id, String numeroBus, String placa, LocalDateTime fechaCreacion, String caracteristicas, MarcaBus marca, boolean activo) {
        this.id = id;
        this.numeroBus = numeroBus;
        this.placa = placa;
        this.fechaCreacion = fechaCreacion;
        this.caracteristicas = caracteristicas;
        this.marca = marca;
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

    public MarcaBus getMarca() {
        return marca;
    }

    public void setMarca(MarcaBus marca) {
        this.marca = marca;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Métodos hashCode, equals y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return activo == bus.activo &&
                Objects.equals(id, bus.id) &&
                Objects.equals(numeroBus, bus.numeroBus) &&
                Objects.equals(placa, bus.placa) &&
                Objects.equals(fechaCreacion, bus.fechaCreacion) &&
                Objects.equals(caracteristicas, bus.caracteristicas) &&
                Objects.equals(marca, bus.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroBus, placa, fechaCreacion, caracteristicas, marca, activo);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", numeroBus='" + numeroBus + '\'' +
                ", placa='" + placa + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", marca=" + marca +
                ", activo=" + activo +
                '}';
    }
}

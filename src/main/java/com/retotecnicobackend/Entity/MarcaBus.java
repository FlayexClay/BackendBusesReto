package com.retotecnicobackend.Entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "marcas")
public class MarcaBus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    // Constructor vacío (JPA requiere esto)
    public MarcaBus() {}

    // Constructor con parámetros
    public MarcaBus(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos hashCode, equals y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarcaBus marcaBus = (MarcaBus) o;
        return Objects.equals(id, marcaBus.id) &&
                Objects.equals(nombre, marcaBus.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "MarcaBus{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}


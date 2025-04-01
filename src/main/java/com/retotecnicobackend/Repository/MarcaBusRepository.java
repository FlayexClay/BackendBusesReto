package com.retotecnicobackend.Repository;

import com.retotecnicobackend.Entity.MarcaBus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaBusRepository  extends JpaRepository<MarcaBus, Long> {
    boolean existsByNombre(String nombre);
}

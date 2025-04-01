package com.retotecnicobackend.Repository;

import com.retotecnicobackend.Entity.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    Page<Bus> findAll(Pageable pageable);
}

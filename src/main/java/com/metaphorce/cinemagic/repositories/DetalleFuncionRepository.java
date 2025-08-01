package com.metaphorce.cinemagic.repositories;

import com.metaphorce.cinemagic.entities.DetalleFuncion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFuncionRepository extends JpaRepository<DetalleFuncion, Integer> {
}

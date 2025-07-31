package com.metaphorce.cinemagic.repositories;

import com.metaphorce.cinemagic.entities.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReseniaRepository extends JpaRepository<Resenia, Integer> {
}

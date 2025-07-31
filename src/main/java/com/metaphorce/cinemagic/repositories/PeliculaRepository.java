package com.metaphorce.cinemagic.repositories;

import com.metaphorce.cinemagic.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

}

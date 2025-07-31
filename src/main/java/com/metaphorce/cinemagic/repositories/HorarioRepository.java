package com.metaphorce.cinemagic.repositories;

import com.metaphorce.cinemagic.entities.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {

}

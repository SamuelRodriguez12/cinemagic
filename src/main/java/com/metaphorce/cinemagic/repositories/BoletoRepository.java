package com.metaphorce.cinemagic.repositories;

import com.metaphorce.cinemagic.entities.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Integer> {

}

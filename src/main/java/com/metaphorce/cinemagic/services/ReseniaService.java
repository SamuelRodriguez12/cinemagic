package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Resenia;

import java.util.List;

public interface ReseniaService {

    List<Resenia> getResenia();

    Resenia sendResenia(Resenia resenia);

    Resenia updateResenia(Integer id, Resenia resenia);

    Boolean deleteResenia(Integer id);
}

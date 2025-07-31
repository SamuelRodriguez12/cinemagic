package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Horario;

import java.util.List;

public interface HorarioService {

    List<Horario> getHorario();

    Horario sendHorario(Horario horario);

    Horario updateHorario(Integer id, Horario horario);

    Boolean deleteHorario(Integer id);
}

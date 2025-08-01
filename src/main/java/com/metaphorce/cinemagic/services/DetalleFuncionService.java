package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.DetalleFuncion;

import java.util.List;

public interface DetalleFuncionService {

    List<DetalleFuncion> getDetalleFuncion();

    DetalleFuncion sendDetalleFuncion(DetalleFuncion detalleFuncion);

    DetalleFuncion updateDetalleFuncion(Integer id, DetalleFuncion detalleFuncion);

    Boolean deleteDetalleFuncion(Integer id);
}

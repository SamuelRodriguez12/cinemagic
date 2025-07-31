package com.metaphorce.cinemagic.services;


import com.metaphorce.cinemagic.entities.Pelicula;

import java.util.List;

public interface PeliculaService {

    List<Pelicula> getPelicula();

    Pelicula sendPelicula(Pelicula pelicula);

    Pelicula updatePelicula(Integer id, Pelicula pelicula);

    Boolean deletePelicula(Integer id);
}

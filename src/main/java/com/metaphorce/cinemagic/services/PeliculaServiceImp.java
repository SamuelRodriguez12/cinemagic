package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Pelicula;
import com.metaphorce.cinemagic.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImp implements PeliculaService{

    @Autowired
    PeliculaRepository repository;

    @Override
    public List<Pelicula> getPelicula(){
        return repository.findAll();
    }

    @Override
    public Pelicula sendPelicula(Pelicula pelicula){
        return repository.save(pelicula);
    }

    @Override
    public Pelicula updatePelicula(Integer id, Pelicula pelicula){
        Pelicula peli = repository.findById(id).orElse(null);
        if (peli == null){
            return null;
        }
        peli.setNombrePelicula(pelicula.getNombrePelicula());
        return repository.save(peli);
    }

    @Override
    public Boolean deletePelicula(Integer id){
        Pelicula peli = repository.findById(id).orElse(null);
        if(peli == null){
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}

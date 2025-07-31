package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Resenia;
import com.metaphorce.cinemagic.repositories.ReseniaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseniaServiceImp implements ReseniaService {

    @Autowired
    ReseniaRepository repository;

    @Override
    public List<Resenia> getResenia(){
        return repository.findAll();
    }

    @Override
    public Resenia sendResenia(Resenia resenia){
        return repository.save(resenia);
    }

    @Override
    public Resenia updateResenia(Integer id, Resenia resenia){
        Resenia res = repository.findById(id).orElse(null);
        if(res == null){
            return null;
        }
        res.setDetalleResenia(resenia.getDetalleResenia());
        res.setCalificacion(resenia.getCalificacion());
        res.setPelicula(resenia.getPelicula());
        return repository.save(res);
    }

    @Override
    public Boolean deleteResenia(Integer id){
        Resenia resenia = repository.findById(id).orElse(null);
        if(resenia == null){
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}

package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.DetalleFuncion;
import com.metaphorce.cinemagic.repositories.DetalleFuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleFuncionServiceImp implements DetalleFuncionService{

    @Autowired
    DetalleFuncionRepository repository;

    public List<DetalleFuncion> getDetalleFuncion(){
        return repository.findAll();
    }

    public DetalleFuncion sendDetalleFuncion(DetalleFuncion detalleFuncion){
        return repository.save(detalleFuncion);
    }

    public DetalleFuncion updateDetalleFuncion(Integer id, DetalleFuncion detalleFuncion){
        DetalleFuncion funcion = repository.findById(id).orElse(null);
        if(funcion == null){
            return null;
        }
        funcion.setBoleto(detalleFuncion.getBoleto());
        funcion.setHorario(detalleFuncion.getHorario());
        return repository.save(funcion);
    }

    public Boolean deleteDetalleFuncion(Integer id){
        DetalleFuncion detalleFuncion = repository.findById(id).orElse(null);
        if(detalleFuncion == null){
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}

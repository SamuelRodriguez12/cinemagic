package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Horario;
import com.metaphorce.cinemagic.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioServiceImp implements HorarioService{

    @Autowired
    HorarioRepository repository;

    @Override
    public List<Horario> getHorario(){
        return repository.findAll();
    }

    @Override
    public Horario sendHorario(Horario horario){
        return repository.save(horario);
    }

    @Override
    public Horario updateHorario(Integer id, Horario horario){
        Horario hor = repository.findById(id).orElse(null);
        if(hor == null){
            return null;
        }
        hor.setFecha(horario.getFecha());
        hor.setHoraInicio(horario.getFecha());
        hor.setHoraFin(horario.getHoraFin());
        hor.setPelicula(horario.getPelicula());
        return repository.save(hor);
    }

    @Override
    public Boolean deleteHorario(Integer id){
        Horario horario = repository.findById(id).orElse(null);
        if(horario == null){
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}

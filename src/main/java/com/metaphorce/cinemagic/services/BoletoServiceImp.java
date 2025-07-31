package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Boleto;
import com.metaphorce.cinemagic.repositories.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletoServiceImp implements BoletoService{

    @Autowired
    BoletoRepository repository;

    @Override
    public List<Boleto> getBoleto(){
        return repository.findAll();
    }

    @Override
    public Boleto sendBoleto(Boleto boleto){
        return repository.save(boleto);
    }

    @Override
    public Boleto updateBoleto(Integer id, Boleto boleto){
        Boleto bol = repository.findById(id).orElse(null);
        if(bol == null){
            return null;
        }
        bol.setAsientos(boleto.getAsientos());
        bol.setPrecio(boleto.getPrecio());
        bol.setEstatus(boleto.getEstatus());
        return repository.save(bol);
    }

    @Override
    public Boolean deleteBoleto(Integer id){
        Boleto boleto = repository.findById(id).orElse(null);
        if(boleto == null){
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}

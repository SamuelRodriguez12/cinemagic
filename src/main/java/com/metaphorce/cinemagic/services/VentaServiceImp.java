package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Venta;
import com.metaphorce.cinemagic.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImp implements VentaService{

    @Autowired
    VentaRepository repository;

    public List<Venta> getVenta(){
        return repository.findAll();
    }

    public Venta sendVenta(Venta venta){
        return repository.save(venta);
    }

    public Venta updateVenta(Integer id, Venta venta){
        Venta ven = repository.findById(id).orElse(null);
        if (ven == null){
            return null;
        }
        ven.setDetalleFuncion(venta.getDetalleFuncion());
        return repository.save(ven);
    }

    public Boolean deleteVenta(Integer id){
        Venta venta = repository.findById(id).orElse(null);
        if(venta == null){
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}

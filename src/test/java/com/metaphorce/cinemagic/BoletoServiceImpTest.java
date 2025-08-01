package com.metaphorce.cinemagic;

import com.metaphorce.cinemagic.entities.Boleto;
import com.metaphorce.cinemagic.repositories.BoletoRepository;
import com.metaphorce.cinemagic.services.BoletoServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.when;

public class BoletoServiceImpTest {

    @Mock
    BoletoRepository repository;
    @InjectMocks
    BoletoServiceImp service;
    Boleto boleto;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        boleto = new Boleto();
        boleto.setIdBoleto(1);
        boleto.setAsientos("A1");
        boleto.setPrecio(45.5);
        boleto.setEstatus(true);
    }

    @Test
    public void testGetBoleto(){
        when(repository.findAll()).thenReturn(List.of(boleto));
        List<Boleto> boletos = service.getBoleto();
        assertEquals(45.5, boletos.get(0).getPrecio());
    }

    @Test
    public void testSendBoleto(){
        when(repository.save(boleto)).thenReturn(boleto);
        Boleto boletoNuevo = service.sendBoleto(boleto);
        assertEquals("A1", boleto.getAsientos());
    }

    @Test
    public void testUpdateBoleto(){
        when(repository.findById(boleto.getIdBoleto())).thenReturn(Optional.ofNullable(boleto));
        boleto.setEstatus(false);
        when(repository.save(boleto)).thenReturn(boleto);
        Boleto boletoActualizado = service.updateBoleto(boleto.getIdBoleto(), boleto);
        assertEquals(false, boletoActualizado.getEstatus());
    }

    @Test
    public void testDeleteBoleto(){
        when(repository.findById(boleto.getIdBoleto())).thenReturn(Optional.ofNullable(boleto));
        willDoNothing().given(repository).deleteById(1);
        Boolean boletoEstado = service.deleteBoleto(1);
        assertEquals(true, boletoEstado);
    }
}

package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Boleto;

import java.util.List;

public interface BoletoService {

    List<Boleto> getBoleto();

    Boleto sendBoleto(Boleto boleto);

    Boleto updateBoleto(Integer id, Boleto boleto);

    Boolean deleteBoleto(Integer id);
}

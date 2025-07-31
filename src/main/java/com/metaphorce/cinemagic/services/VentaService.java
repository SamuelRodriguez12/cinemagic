package com.metaphorce.cinemagic.services;

import com.metaphorce.cinemagic.entities.Venta;

import java.util.List;

public interface VentaService {

    List<Venta> getVenta();

    Venta sendVenta(Venta venta);

    Venta updateVenta(Integer id, Venta venta);

    Boolean deleteVenta(Integer id);
}

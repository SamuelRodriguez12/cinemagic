package com.metaphorce.cinemagic.entities;

import java.util.List;

public class ReporteVentas {
    private Integer idVenta;
    private String nombrePelicula;
    private String fecha;
    private List<Boleto> boletos;

    public ReporteVentas(Integer idVenta, String nombrePelicula, String fecha, List<Boleto> boletos) {
        this.idVenta = idVenta;
        this.nombrePelicula = nombrePelicula;
        this.fecha = fecha;
        this.boletos = boletos;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }
}

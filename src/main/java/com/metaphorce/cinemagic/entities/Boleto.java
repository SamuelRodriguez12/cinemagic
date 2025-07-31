package com.metaphorce.cinemagic.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Boleto")
public class Boleto {
    @Id
    private Integer idBoleto;
    private String asientos;
    private Double precio;
    private Boolean estatus;

    public Boleto() {
    }

    public Boleto(Integer idBoleto, String asientos, Double precio, Boolean estatus) {
        this.idBoleto = idBoleto;
        this.asientos = asientos;
        this.precio = precio;
        this.estatus = estatus;
    }

    public Integer getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    public String getAsientos() {
        return asientos;
    }

    public void setAsientos(String asientos) {
        this.asientos = asientos;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }
}

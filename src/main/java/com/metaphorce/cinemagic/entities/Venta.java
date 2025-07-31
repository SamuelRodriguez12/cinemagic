package com.metaphorce.cinemagic.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Venta")
public class Venta {
    @Id
    private Integer idVenta;
    private Horario horario;
    private Boleto boleto;

    public Venta() {
    }

    public Venta(Integer idVenta, Horario horario, Boleto boleto) {
        this.idVenta = idVenta;
        this.horario = horario;
        this.boleto = boleto;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }
}

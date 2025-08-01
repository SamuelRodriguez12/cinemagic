package com.metaphorce.cinemagic.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Venta")
public class Venta {
    @Id
    @Column(name = "id_venta")
    private Integer idVenta;
    @OneToOne
    @JoinColumn(name = "id_detalle_funcion")
    private DetalleFuncion detalleFuncion;

    public Venta() {
    }

    public Venta(Integer idVenta, DetalleFuncion detalleFuncion) {
        this.idVenta = idVenta;
        this.detalleFuncion = detalleFuncion;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public DetalleFuncion getDetalleFuncion() {
        return detalleFuncion;
    }

    public void setDetalleFuncion(DetalleFuncion detalleFuncion) {
        this.detalleFuncion = detalleFuncion;
    }
}

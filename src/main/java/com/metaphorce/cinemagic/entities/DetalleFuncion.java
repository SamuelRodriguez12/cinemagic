package com.metaphorce.cinemagic.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Detalle_Funcion")
public class DetalleFuncion {
    @Id
    @Column(name = "id_detalle_funcion")
    private Integer idDetalleFuncion;
    @ManyToOne
    @JoinColumn(name = "id_horario")
    private Horario horario;
    @ManyToOne
    @JoinColumn(name = "id_boleto")
    private Boleto boleto;

    public DetalleFuncion() {
    }

    public DetalleFuncion(Integer idDetalleFuncion, Horario horario, Boleto boleto) {
        this.idDetalleFuncion = idDetalleFuncion;
        this.horario = horario;
        this.boleto = boleto;
    }

    public Integer getIdDetalleFuncion() {
        return idDetalleFuncion;
    }

    public void setIdDetalleFuncion(Integer idDetalleFuncion) {
        this.idDetalleFuncion = idDetalleFuncion;
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

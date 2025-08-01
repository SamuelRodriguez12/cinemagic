package com.metaphorce.cinemagic.entities;


import java.util.List;

public class Cartelera {
    private String nombrePelicula;
    private List<Horario> horarios;

    public Cartelera(String nombrePelicula, List<Horario> horarios) {
        this.nombrePelicula = nombrePelicula;
        this.horarios = horarios;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}

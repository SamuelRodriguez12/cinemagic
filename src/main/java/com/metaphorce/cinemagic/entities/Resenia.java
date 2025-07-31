package com.metaphorce.cinemagic.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Resenia")
public class Resenia {
    @Id
    private Integer idResenia;
    private String detalleResenia;
    private Double calificacion;
    private Pelicula pelicula;

    public Resenia() {
    }

    public Resenia(Integer idResenia, String detalleResenia, Double calificacion, Pelicula pelicula) {
        this.idResenia = idResenia;
        this.detalleResenia = detalleResenia;
        this.calificacion = calificacion;
        this.pelicula = pelicula;
    }

    public Integer getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(Integer idResenia) {
        this.idResenia = idResenia;
    }

    public String getDetalleResenia() {
        return detalleResenia;
    }

    public void setDetalleResenia(String detalleResenia) {
        this.detalleResenia = detalleResenia;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}

package com.metaphorce.cinemagic.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pelicula")
public class Pelicula {
    @Id
    private Integer idPelicula;
    private String nombrePelicula;

    public Pelicula() {
    }

    public Pelicula(Integer idPelicula, String nombrePelicula) {
        this.idPelicula = idPelicula;
        this.nombrePelicula = nombrePelicula;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }
}

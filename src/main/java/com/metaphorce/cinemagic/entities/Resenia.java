package com.metaphorce.cinemagic.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Resenia")
public class Resenia {
    @Id
    @Column(name = "id_resenia")
    private Integer idResenia;
    @Column(name = "detalle_resenia")
    @NotBlank(message = "No puedes subir una resenia sin escribir sus detalles")
    private String detalleResenia;
    @Column(name = "calificacion")
    @NotNull(message = "Tienes que darle una calificacion a la pelicula")
    @DecimalMin(value = "0.0", message = "El valor no puede ser menor a 0")
    @DecimalMax(value = "5.0", message = "El valor no puede ser mayor a 5")
    private Double calificacion;
    @ManyToOne
    @JoinColumn(name = "id_pelicula")
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

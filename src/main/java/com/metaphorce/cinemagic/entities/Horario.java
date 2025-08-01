package com.metaphorce.cinemagic.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Horario")
public class Horario {
    @Id
    @Column(name = "id_horario")
    private Integer idHorario;
    @Column(name = "fecha")
    @NotBlank(message = "Debes ingresar la fecha")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "La fecha debe tener formato DD-MM-YYYY")
    private String fecha;
    @Column(name = "hora_inicio")
    @NotBlank(message = "Debes ingresar el horario de inicio")
    @Pattern(regexp = "\\d{2}:\\d{2}", message = "La hora debe de tener un formato de HH:mm")
    private String horaInicio;
    @Column(name = "hora_fin")
    @NotBlank(message = "Debes ingresar el horario de termino")
    @Pattern(regexp = "\\d{2}:\\d{2}", message = "La hora debe de tener un formato de HH:mm")
    private String horaFin;
    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    public Horario() {
    }

    public Horario(Integer idHorario, String fecha, String horaInicio, String horaFin, Pelicula pelicula) {
        this.idHorario = idHorario;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.pelicula = pelicula;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}

package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.*;
import com.metaphorce.cinemagic.exceptions.DatosNoValidosException;
import com.metaphorce.cinemagic.repositories.PeliculaRepository;
import com.metaphorce.cinemagic.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cinemagic")
public class AdministradorController {

    @Autowired
    PeliculaRepository peliculaRepository;
    @Autowired
    PeliculaService peliculaService;
    @Autowired
    BoletoService boletoService;
    @Autowired
    HorarioService horarioService;
    @Autowired
    DetalleFuncionService detalleFuncionService;
    @Autowired
    VentaService ventaService;

    @PutMapping("/administrador/pelicula/{idPelicula}/horario/{idHorario}")
    public ResponseEntity<Horario> cambiarHorario(@PathVariable("idPelicula") Integer idPelicula, @PathVariable("idHorario") Integer idHorario, @Valid @RequestBody Horario horario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new DatosNoValidosException("Error de validacion de datos", bindingResult);
        }
        Pelicula pelicula = peliculaRepository.findById(idPelicula).orElse(null);
        Horario nuevoHorario = horarioService.updateHorario(idHorario, horario);
        if (pelicula == null || nuevoHorario == null){
            return null;
        }
        nuevoHorario.setPelicula(pelicula);
        this.horarioService.updateHorario(idHorario, nuevoHorario);
        return ResponseEntity.ok(nuevoHorario);
    }

    @GetMapping("/administrador/ventas")
    public ResponseEntity<List<ReporteVentas>> analisisVentas(){
       List<Venta> ventas = ventaService.getVenta();
       List<ReporteVentas> reporte = new ArrayList<>();
       for (Venta venta : ventas){
           DetalleFuncion detalle = venta.getDetalleFuncion();
           Horario horario = detalle.getHorario();
           Boleto boleto = detalle.getBoleto();
           Pelicula pelicula = horario.getPelicula();

           ReporteVentas analisis = new ReporteVentas(venta.getIdVenta(), horario.getPelicula().getNombrePelicula(), horario.getFecha(), List.of(boleto));
           reporte.add(analisis);
       }
       return ResponseEntity.ok(reporte);
    }
}

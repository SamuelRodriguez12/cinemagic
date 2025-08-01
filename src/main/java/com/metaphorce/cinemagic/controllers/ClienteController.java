package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.*;
import com.metaphorce.cinemagic.repositories.BoletoRepository;
import com.metaphorce.cinemagic.repositories.HorarioRepository;
import com.metaphorce.cinemagic.repositories.PeliculaRepository;
import com.metaphorce.cinemagic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cinemagic")
public class ClienteController {

    @Autowired
    PeliculaService peliculaService;
    @Autowired
    PeliculaRepository peliculaRepository;
    @Autowired
    HorarioService horarioService;
    @Autowired
    HorarioRepository horarioRepository;
    @Autowired
    BoletoRepository boletoRepository;
    @Autowired
    ReseniaService reseniaService;
    @Autowired
    DetalleFuncionService detalleFuncionService;
    @Autowired
    VentaService ventaService;

    @GetMapping("/cliente/cartelera")
    public ResponseEntity<List<Cartelera>> obtenerCartelera(){
        List<Pelicula> peliculas = peliculaService.getPelicula();
        List<Horario> horarios = horarioService.getHorario();

        List<Cartelera> cartelera = new ArrayList<>();

        for (Pelicula peli : peliculas){
            List<Horario> horariosPorPelicula = horarios.stream().filter(horario -> horario.getPelicula().getIdPelicula().equals(peli.getIdPelicula())).collect(Collectors.toList());
            if (!horariosPorPelicula.isEmpty()){
                cartelera.add(new Cartelera(peli.getNombrePelicula(), horariosPorPelicula));
            }
        }
        return ResponseEntity.ok(cartelera);
    }

    @PostMapping("/cliente/comprar_boleto/pelicula/{idPelicula}/horario/{idHorario}/boleto/{idBoleto}")
    public ResponseEntity<Venta> comprarBoleto(@PathVariable("idPelicula") Integer idPelicula, @PathVariable("idHorario") Integer idHorario, @PathVariable("idBoleto") Integer idBoleto, @RequestBody DetalleFuncion detalleFuncion){
        Horario horario = horarioRepository.findById(idHorario).orElse(null);
        Boleto boleto = boletoRepository.findById(idBoleto).orElse(null);
        Pelicula pelicula = peliculaRepository.findById(idPelicula).orElse(null);
        if(horario == null || boleto == null || pelicula == null){
            return null;
        }
        horario.setPelicula(pelicula);
        detalleFuncion.setHorario(horario);
        detalleFuncion.setBoleto(boleto);
        detalleFuncionService.sendDetalleFuncion(detalleFuncion);
        Venta ultima = ventaService.getVenta().get(ventaService.getVenta().size()-1);
        Venta nuevo = new Venta(ultima.getIdVenta()+1, detalleFuncion);
        return ResponseEntity.ok(this.ventaService.sendVenta(nuevo));
    }

    @PostMapping("/cliente/reseniar/pelicula/{idPelicula}")
    public ResponseEntity<Resenia> ingresarResenia(@PathVariable("idPelicula") Integer idPelicula,@RequestBody Resenia resenia){
        Pelicula pelicula = peliculaRepository.findById(idPelicula).orElse(null);
        if(pelicula == null){
            return null;
        }
        Resenia ultima = reseniaService.getResenia().get(reseniaService.getResenia().size()-1);
        resenia.setIdResenia(ultima.getIdResenia()+1);
        resenia.setPelicula(pelicula);
        return ResponseEntity.ok(this.reseniaService.sendResenia(resenia));
    }
}

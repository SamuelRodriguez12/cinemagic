package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Pelicula;
import com.metaphorce.cinemagic.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemagic")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping("/peliculas")
    public ResponseEntity<List<Pelicula>> obtenerPeliculas(){
        List<Pelicula> peliculas = peliculaService.getPelicula();
        return ResponseEntity.ok().body(peliculas);
    }

    @PostMapping("/peliculas")
    public ResponseEntity<Pelicula> guardarPelicula(@RequestBody Pelicula pelicula){
        return ResponseEntity.ok(this.peliculaService.sendPelicula(pelicula));
    }

    @PutMapping("/peliculas/{idPelicula}")
    public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable("idPelicula") Integer idPelicula, @RequestBody Pelicula pelicula){
        Pelicula nuevo = peliculaService.updatePelicula(idPelicula, pelicula);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/peliculas/{idPelicula}")
    public String eliminarPelicula(@PathVariable("idPelicula") Integer idPelicula){
            Boolean estado = peliculaService.deletePelicula(idPelicula);
            if(estado == true){
                return "La pelicula ha sido eliminada con exito";
            }
            return "La pelicula no existe";
    }
}

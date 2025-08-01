package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Resenia;
import com.metaphorce.cinemagic.services.ReseniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemagic")
public class ReseniaController {

    @Autowired
    ReseniaService reseniaService;

    @GetMapping("/resenias")
    public ResponseEntity<List<Resenia>> obtenereResenias(){
        List<Resenia> resenias = reseniaService.getResenia();
        return ResponseEntity.ok().body(resenias);
    }

    @PostMapping("/resenias")
    public ResponseEntity<Resenia> guardarResenia(@RequestBody Resenia resenia){
        return ResponseEntity.ok(this.reseniaService.sendResenia(resenia));
    }

    @PutMapping("/resenias/{idResenia}")
    public ResponseEntity<Resenia> actualizarResenia(@PathVariable("idResenia") Integer idResenia, @RequestBody Resenia resenia){
        Resenia nuevo = reseniaService.updateResenia(idResenia, resenia);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/resenias/{idResenia}")
    public String eliminarResenia(@PathVariable("idResenia") Integer idResenia){
        Boolean estado = reseniaService.deleteResenia(idResenia);
        if(estado == true){
            return "La resenia ha sido eliminada con exito";
        }
        return "La resenia no existe";
    }
}

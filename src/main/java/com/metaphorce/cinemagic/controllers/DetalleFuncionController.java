package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.DetalleFuncion;
import com.metaphorce.cinemagic.services.DetalleFuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemagic")
public class DetalleFuncionController {

    @Autowired
    DetalleFuncionService detalleFuncionService;

    @GetMapping("/detallesFuncion")
    public ResponseEntity<List<DetalleFuncion>> obtenerDetallesFuncion(){
        List<DetalleFuncion> detalleFuncionList = detalleFuncionService.getDetalleFuncion();
        return ResponseEntity.ok().body(detalleFuncionList);
    }

    @PostMapping("/detallesFuncion")
    public ResponseEntity<DetalleFuncion> guardarDetalleFuncion(@RequestBody DetalleFuncion detalleFuncion){
        return ResponseEntity.ok(this.detalleFuncionService.sendDetalleFuncion(detalleFuncion));
    }

    @PutMapping("/detallesFuncion/{idDetalleFuncion}")
    public ResponseEntity<DetalleFuncion> actualizarDetalleFuncion(@PathVariable("idDetalleFuncion") Integer idDetalleFuncion, @RequestBody DetalleFuncion detalleFuncion){
        DetalleFuncion nuevo = detalleFuncionService.updateDetalleFuncion(idDetalleFuncion, detalleFuncion);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/detallesFuncion/{idDetalleFuncion}")
    public String eliminarDetalleFuncion(@PathVariable("idDetalleFuncion") Integer idDetalleFuncion){
        Boolean estado = detalleFuncionService.deleteDetalleFuncion(idDetalleFuncion);
        if(estado == true){
            return "Los detalles de la funcion han sido eliminados con exito";
        }
        return "Los detalles de la funcion no existen";
    }
}

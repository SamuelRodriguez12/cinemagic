package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Venta;
import com.metaphorce.cinemagic.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemagic")
public class VentaController {

    @Autowired
    VentaService ventaService;

    @GetMapping("/ventas")
    public ResponseEntity<List<Venta>> obtenerVenta(){
        List<Venta> ventas = ventaService.getVenta();
        return ResponseEntity.ok().body(ventas);
    }

    @PostMapping("/ventas")
    public ResponseEntity<Venta> guardarVenta(@RequestBody Venta venta){
        return ResponseEntity.ok(this.ventaService.sendVenta(venta));
    }

    @PutMapping("/ventas/{idVenta}")
    public ResponseEntity<Venta> actualizarVenta(@PathVariable("idVenta") Integer idVenta, @RequestBody Venta venta){
        Venta nuevo = ventaService.updateVenta(idVenta, venta);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/ventas/{idVenta}")
    public String eliminarVenta(@PathVariable("idVenta") Integer idVenta){
        Boolean estado = ventaService.deleteVenta(idVenta);
        if(estado == true){
            return "La venta ha sido eliminada con exito";
        }
        return "La venta no existe";
    }
}

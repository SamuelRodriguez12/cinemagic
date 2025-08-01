package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Boleto;
import com.metaphorce.cinemagic.services.BoletoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemagic")
public class BoletoController {

    @Autowired
    BoletoService boletoService;

    @GetMapping("/boletos")
    public ResponseEntity<List<Boleto>> obtenerBoletos(){
        List<Boleto> boletos = boletoService.getBoleto();
        return  ResponseEntity.ok().body(boletos);
    }

    @PostMapping("/boletos")
    public ResponseEntity<Boleto> guardarBoleto(@RequestBody Boleto boleto){
        return ResponseEntity.ok(this.boletoService.sendBoleto(boleto));
    }

    @PutMapping("/boletos/{idBoleto}")
    public ResponseEntity<Boleto> actualizarBoleto(@PathVariable("idBoleto") Integer idBoleto, @RequestBody Boleto boleto){
        Boleto nuevo = boletoService.updateBoleto(idBoleto, boleto);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/boletos/{idBoleto}")
    public String eliminarBoleto(@PathVariable("idBoleto") Integer idBoleto){
        Boolean estado = boletoService.deleteBoleto(idBoleto);
        if(estado == true){
            return "El boleto fue eliminado con exito";
        }
        return "El boleto nu fue encontrando";
    }
}

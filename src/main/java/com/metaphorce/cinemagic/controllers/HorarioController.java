package com.metaphorce.cinemagic.controllers;

import com.metaphorce.cinemagic.entities.Horario;
import com.metaphorce.cinemagic.services.HorarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemagic")
public class HorarioController {

    @Autowired
    HorarioService horarioService;

    @GetMapping("/horarios")
    public ResponseEntity<List<Horario>> obtenerHorarios(){
        List<Horario> horarios = horarioService.getHorario();
        return ResponseEntity.ok().body(horarios);
    }

    @PostMapping("/horarios")
    public ResponseEntity<Horario> guardarHorario(@RequestBody Horario horario){
        return ResponseEntity.ok(this.horarioService.sendHorario(horario));
    }

    @PutMapping("/horarios/{idHorario}")
    public ResponseEntity<Horario> actualizarHorario(@PathVariable("idHorario") Integer idHorario, @RequestBody Horario horario){
        Horario nuevo = horarioService.updateHorario(idHorario, horario);
        return ResponseEntity.ok(nuevo);
    }

    @DeleteMapping("/horarios/{idHorario}")
    public String eliminarHorario(@PathVariable("idHorario") Integer idHorario){
        Boolean estado = horarioService.deleteHorario(idHorario);
        if(estado == true){
            return "El horario se ha eliminado con exito";
        }
        return "El horario no se ha encontrado";
    }
}

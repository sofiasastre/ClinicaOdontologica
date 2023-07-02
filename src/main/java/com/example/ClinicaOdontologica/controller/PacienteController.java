package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.modelo.PacienteDTO;
import com.example.ClinicaOdontologica.service.IPacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.crearPaciente(pacienteDTO);
        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO getPaciente(@PathVariable Integer id){
        return pacienteService.leerPaciente(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Integer id){
        try {
            pacienteService.eliminarPaciente(id);
            String mensaje = "Se eliminó correctamente el paciente con ID: " + id;
            logger.info(mensaje);
            return ResponseEntity.ok(mensaje);
        } catch (EmptyResultDataAccessException ex) {
            logger.info("No se encontró ningún paciente con el ID: " + id);
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public Collection<PacienteDTO> getTodosPacientes(){
        return pacienteService.getTodos();
    }
}

package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.modelo.DomicilioDTO;
import com.example.ClinicaOdontologica.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {
    @Autowired
    private IDomicilioService domicilioService;

    @PostMapping()
    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.crearDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DomicilioDTO getDomicilio(@PathVariable Integer id){
        return domicilioService.leerDomicilio(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.modificarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  eliminarDomicilio(@PathVariable Integer id) {
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<DomicilioDTO> getTodosDomicilios(){
        return domicilioService.getTodos();
    }
}

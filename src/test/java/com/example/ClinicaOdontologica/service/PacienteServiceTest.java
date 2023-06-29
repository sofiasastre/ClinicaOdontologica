package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.modelo.Domicilio;
import com.example.ClinicaOdontologica.modelo.DomicilioDTO;
import com.example.ClinicaOdontologica.modelo.Paciente;
import com.example.ClinicaOdontologica.modelo.PacienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private IPacienteService pacienteService;

    @Test
    public void testCrearPaciente(){
        //Se crea domicilio

        DomicilioDTO domicilioDTO1 = new DomicilioDTO();
        domicilioDTO1.setCalle("Lorenzo Carnelli");
        domicilioDTO1.setNumero("1234");
        domicilioDTO1.setLocalidad("Montevideo");
        domicilioDTO1.setProvincia("Montevideo");

        //Se crea Paciente
        PacienteDTO pacienteDTO1 = new PacienteDTO();
        pacienteDTO1.setNombre("Emilia");
        pacienteDTO1.setApellido("Rodriguez");
        pacienteDTO1.setDni("99999999");
        pacienteDTO1.setDomicilio(domicilioDTO1);
        LocalDate fechaIngreso = LocalDate.of(2022, 11, 13);
        Date dateFechaIngreso = Date.from(fechaIngreso.atStartOfDay(ZoneId.systemDefault()).toInstant());
        pacienteDTO1.setFechaIngreso(dateFechaIngreso);

        pacienteService.crearPaciente(pacienteDTO1);

        PacienteDTO pacienteEmilia = pacienteService.leerPaciente(1);
        assertTrue(pacienteEmilia != null);


    }
}
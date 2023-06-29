package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.modelo.OdontologoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void testCrearOdontologo(){
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Sofía2");
        odontologoDTO.setApellido("Sastre2");
        odontologoDTO.setMatricula("123abc");

        OdontologoDTO odontologoDTO2 = new OdontologoDTO();
        odontologoDTO2.setMatricula("456def");
        odontologoDTO2.setNombre("Nicolás");
        odontologoDTO2.setApellido("Vaz");

        odontologoService.crearOdontologo(odontologoDTO);
        odontologoService.crearOdontologo(odontologoDTO2);

        OdontologoDTO odontologoSofia = odontologoService.leerOdontologo(1);
        assertTrue(odontologoSofia != null);
    }

}
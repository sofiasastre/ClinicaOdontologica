package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.modelo.Odontologo;
import com.example.ClinicaOdontologica.modelo.OdontologoDTO;
import com.example.ClinicaOdontologica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{
    @Autowired
    private IOdontologoRepository odontologoRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }
    @Override
    public OdontologoDTO leerOdontologo(Integer id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent())
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);

        return odontologoDTO;
    }
    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }
    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }
    @Override
    public void eliminarOdontologo(Integer id) {
        odontologoRepository.deleteById(id);
    }
    @Override
    public Set<OdontologoDTO> getTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOS = new HashSet<>();
        for (Odontologo odontologo: odontologos){
            odontologoDTOS.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologoDTOS;
    }
}


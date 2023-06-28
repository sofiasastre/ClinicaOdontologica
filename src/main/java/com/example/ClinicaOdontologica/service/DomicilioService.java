package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.modelo.Domicilio;
import com.example.ClinicaOdontologica.modelo.DomicilioDTO;
import com.example.ClinicaOdontologica.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService {
    @Autowired
    private IDomicilioRepository domicilioRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
    }

    @Override
    public DomicilioDTO leerDomicilio(Integer id){
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if(domicilio.isPresent())
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);

        return domicilioDTO;
    }
    private void guardarDomicilio(DomicilioDTO domicilioDTO){
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }
    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO){guardarDomicilio(domicilioDTO);}
    @Override
    public void eliminarDomicilio(Integer id){ domicilioRepository.deleteById(id);}
    @Override
    public Set<DomicilioDTO> getTodos(){
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTOS = new HashSet<>();
        for(Domicilio domicilio: domicilios){
            domicilioDTOS.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        return domicilioDTOS;
    }
}

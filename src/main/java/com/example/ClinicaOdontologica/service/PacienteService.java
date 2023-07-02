package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.modelo.Paciente;
import com.example.ClinicaOdontologica.modelo.PacienteDTO;
import com.example.ClinicaOdontologica.modelo.Turno;
import com.example.ClinicaOdontologica.modelo.TurnoDTO;
import com.example.ClinicaOdontologica.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.ClinicaOdontologica.repository.ITurnoRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class PacienteService implements IPacienteService{
    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    private ITurnoRepository turnoRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
    }
    @Override
    public PacienteDTO leerPaciente(Integer id) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(pacienteOptional.isPresent()){
            Paciente paciente = pacienteOptional.get();
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }


        return pacienteDTO;
    }
    private void guardarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }
    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
    }

    @Override
    public void eliminarPaciente(Integer id) {
        try {
            Paciente paciente = pacienteRepository.findById(id).orElse(null);
            List<Turno> turnosEliminados = new ArrayList<>();
            if (paciente != null) {
                Set<Turno> turnos = paciente.getTurnos();
                if (turnos != null) {
                    for (Turno turno : turnos) {
                        turno.setPaciente(null);  // Establecer el paciente en null
                        turnoRepository.delete(turno);
                        turnosEliminados.add(turno);
                    }
                }
                pacienteRepository.deleteById(id);
            }
            if (!turnosEliminados.isEmpty()) {
                String mensaje = "Se eliminó correctamente el paciente con ID: " + id + " y los siguientes turnos: " + turnosEliminados;
                throw new ResponseStatusException(HttpStatus.OK, mensaje);
            } else {
                String mensaje = "Se eliminó correctamente el paciente con ID: " + id + " y no se encontraron turnos relacionados.";
                throw new ResponseStatusException(HttpStatus.OK, mensaje);
            }
        } catch (EmptyResultDataAccessException ex) {
            String mensaje = "No se encontró ningún paciente con el ID: " + id;
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, mensaje);
        }
    }



    @Override
    public Set<PacienteDTO> getTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOS = new HashSet<>();
        for(Paciente paciente: pacientes){
            pacienteDTOS.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacienteDTOS;
    }
}

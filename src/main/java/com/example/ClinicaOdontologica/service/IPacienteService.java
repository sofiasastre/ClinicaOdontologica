package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.modelo.PacienteDTO;
import com.example.ClinicaOdontologica.modelo.TurnoDTO;

import java.util.List;
import java.util.Set;

public interface IPacienteService {
    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO leerPaciente(Integer id);
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Integer id);
    Set<PacienteDTO> getTodos();
}

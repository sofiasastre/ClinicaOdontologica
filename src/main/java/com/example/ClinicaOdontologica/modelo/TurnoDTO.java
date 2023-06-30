package com.example.ClinicaOdontologica.modelo;

import java.time.LocalDate;
import java.util.Date;

public class TurnoDTO {
    private Integer id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate date;

    //Constructores

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

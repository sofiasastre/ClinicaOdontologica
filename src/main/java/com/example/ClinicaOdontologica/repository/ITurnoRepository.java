package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.modelo.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Integer>{
}

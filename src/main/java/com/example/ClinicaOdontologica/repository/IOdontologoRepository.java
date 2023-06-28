package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.modelo.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {

}

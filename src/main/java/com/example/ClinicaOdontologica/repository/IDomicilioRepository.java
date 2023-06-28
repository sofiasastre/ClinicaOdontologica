package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.modelo.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Integer> {
}

package com.senai.augusto.consultasmedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.augusto.consultasmedicas.entidades.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}

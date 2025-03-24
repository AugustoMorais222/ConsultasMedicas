package com.senai.augusto.consultasmedicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.augusto.consultasmedicas.entidades.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{
}


package com.senai.augusto.consultasmedicas.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.augusto.consultasmedicas.entidades.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
	boolean existsByDataAndHorario(Date data, Integer horario);
}
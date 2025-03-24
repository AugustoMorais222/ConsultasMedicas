package com.senai.augusto.consultasmedicas.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Date data;
	
	@Column
	private Integer horario;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

	@Enumerated(EnumType.STRING)
	private Status status;
	
	
	public Consulta(Date data, Integer horario, Paciente paciente, Medico medico, Status status) {
		this.data = data;
		this.horario = horario;
		this.paciente = paciente;
		this.medico = medico;
		this.status = status;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getHorario() {
		return horario;
	}



	public void setHorario(Integer horario) {
		this.horario = horario;
	}



	public Paciente getPaciente() {
		return paciente;
	}



	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}



	public Medico getMedico() {
		return medico;
	}



	public void setMedico(Medico medico) {
		this.medico = medico;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public enum Status{
		AGENDADA,
		CANCELADA,
		REALIZADA
	}
}

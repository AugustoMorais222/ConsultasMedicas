package com.senai.augusto.consultasmedicas.dtos;

import java.text.SimpleDateFormat;

import com.senai.augusto.consultasmedicas.entidades.Consulta;

public class ConsultaDTO {
    private Integer id;
    private String nomePaciente;
    private String nomeMedico;
    private String horario;
    private String status;
    private String data;

    public ConsultaDTO() {
    	
    }
    
    public ConsultaDTO(Consulta consulta) {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.id = consulta.getId();
        this.nomePaciente = consulta.getPaciente() != null ? consulta.getPaciente().getNome() : null;
        this.nomeMedico = consulta.getMedico() != null ? consulta.getMedico().getNome() : null;
        this.status = consulta.getStatus() != null ? consulta.getStatus().toString() : null;
        this.data = consulta.getData() != null ? sdf.format(consulta.getData()): null;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getData() {
		
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
    
    
}

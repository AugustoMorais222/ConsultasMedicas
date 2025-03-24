package com.senai.augusto.consultasmedicas.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.augusto.consultasmedicas.dtos.ConsultaDTO;
import com.senai.augusto.consultasmedicas.entidades.Consulta;
import com.senai.augusto.consultasmedicas.entidades.Medico;
import com.senai.augusto.consultasmedicas.entidades.Paciente;
import com.senai.augusto.consultasmedicas.repository.ConsultaRepository;
import com.senai.augusto.consultasmedicas.repository.MedicoRepository;
import com.senai.augusto.consultasmedicas.repository.PacienteRepository;

@Service
public class ConsultaService {
	
	@Autowired
    private MedicoRepository medicoRepository;
    
	@Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta criarConsulta(Integer medicoId, Integer pacienteId, Date data, Integer horario) {
        Medico medico = medicoRepository.findById(medicoId).orElseThrow(() -> new RuntimeException("Médico não encontrado"));
        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
            if (consultaRepository.existsByDataAndHorario(data, horario)){
                throw new RuntimeException("O Paciente "+paciente.getCpf()+" - "+paciente.getNome()+" já tem consulta marcada nesse horário");
            }
            Consulta consulta = new Consulta(data,horario, paciente, medico, Consulta.Status.AGENDADA);
            return consultaRepository.save(consulta);
    }

    public Consulta cancelarConsulta(Integer consultaId) {
        Consulta consulta = consultaRepository.findById(consultaId).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
            consulta.setStatus(Consulta.Status.CANCELADA);
            return consultaRepository.save(consulta);
    }
	    
	public ConsultaDTO findById(Integer id) {
         Consulta consulta = consultaRepository.findById(id)
        	.orElseThrow(() -> new RuntimeException("Médico não encontrado"));
        return convertToDTO(consulta);
    }
	
	public List<ConsultaDTO> findAll(){
		 List<Consulta> consultas = consultaRepository.findAll();
		 List<ConsultaDTO> consultaDTOs = new ArrayList<>();
		    for (Consulta consulta : consultas) {
		        consultaDTOs.add(this.convertToDTO(consulta));
		    }
		    return consultaDTOs;
	}
	
	public Consulta save(Consulta consulta) {
		return this.consultaRepository.save(consulta);
	}
	
	public void delete(Integer id) {
		this.consultaRepository.deleteById(id);
	}
	
	public Consulta update(Consulta consulta) {
		return save(consulta);
	}
	
	private ConsultaDTO convertToDTO(Consulta consulta) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String horario = consulta.getHorario().toString();
		String[] horarioSplit = horario.split("(?<=\\d{2})(?=\\d{2})");
        ConsultaDTO dto = new ConsultaDTO();
        dto.setId(consulta.getId());
        dto.setNomePaciente(consulta.getPaciente().getNome());
        dto.setNomeMedico(consulta.getMedico().getNome());
        dto.setStatus(consulta.getStatus().name());
        dto.setHorario(horarioSplit[0]+":"+horarioSplit[1]);
        dto.setData(sdf.format(consulta.getData()));
        return dto;
    }
}

package com.senai.augusto.consultasmedicas.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                throw new RuntimeException("Paciente já tem consulta agendada neste horário.");
            }
            Consulta consulta = new Consulta(data,horario, paciente, medico, Consulta.Status.AGENDADA);
            return consultaRepository.save(consulta);
    }

    public Consulta cancelarConsulta(Integer consultaId) {
        Optional<Consulta> consultaOpt = consultaRepository.findById(consultaId);

        if (consultaOpt.isPresent()) {
            Consulta consulta = consultaOpt.get();
            consulta.setStatus(Consulta.Status.CANCELADA);
            return consultaRepository.save(consulta);
        } else {
            throw new RuntimeException("Consulta não encontrada.");
        }
    }
	    
	public Consulta findById(Integer id) {
        return this.consultaRepository.findById(id)
        	.orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }
	
	public List<Consulta> findAll(){
		return this.consultaRepository.findAll();
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
}

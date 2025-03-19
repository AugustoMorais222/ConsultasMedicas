package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Paciente;
import repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public Paciente findById(Integer id) {
	    return this.pacienteRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
	}

	public List<Paciente> findAll(){
		return this.pacienteRepository.findAll();
	}
	
	public Paciente save(Paciente paciente) {
		return this.pacienteRepository.save(paciente);
	}
	
	public void delete(Integer id) {
		this.pacienteRepository.deleteById(id);
	}
	
	public Paciente update(Paciente paciente) {
		return save(paciente);
	}
	
}

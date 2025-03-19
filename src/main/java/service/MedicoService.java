package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Medico;
import repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;
	
	public Medico findById(Integer id) {
	    return this.medicoRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
	}
	
	public List<Medico> findAll(){
		return this.medicoRepository.findAll();
	}
	
	public Medico save(Medico medico) {
		return this.medicoRepository.save(medico);
	}
	
	public void delete(Integer id) {
		this.medicoRepository.deleteById(id);
	}
	
	public Medico update(Medico medico) {
		return save(medico);
	}
	
}

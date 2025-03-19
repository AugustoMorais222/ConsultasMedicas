package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Consulta;
import repository.ConsultaRepository;

@Service
public class ConsultaService {
	
	@Autowired
	private	ConsultaRepository consultaRepository;
	
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

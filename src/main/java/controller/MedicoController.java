package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entidades.Medico;
import jakarta.annotation.PostConstruct;
import service.MedicoService;

@RestController
@RequestMapping("medico/")
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;
	
	@GetMapping("{id}")
	public Medico findById(@PathVariable Integer id) {
		return this.medicoService.findById(id);
	}
	
	@GetMapping
	public List<Medico> findAll(){
		return this.medicoService.findAll();
	}
	
	@PostMapping
	public Medico save(@RequestBody Medico medico) {
		return this.medicoService.save(medico);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		this.medicoService.delete(id);
	}
	
	@PutMapping
	public Medico update(@RequestBody Medico medico) {
		return this.medicoService.update(medico);
	}
}

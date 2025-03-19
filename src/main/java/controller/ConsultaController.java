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

import entidades.Consulta;
import service.ConsultaService;

@RestController
@RequestMapping("consulta/")
public class ConsultaController {
	@Autowired
	private ConsultaService consultaService;
	
	@GetMapping("{id}")
	public Consulta findById(@PathVariable Integer id) {
		return this.consultaService.findById(id);
	}
	
	@GetMapping
	public List<Consulta> findAll(){
		return this.consultaService.findAll();
	}
	
	@PostMapping
	public Consulta save(@RequestBody Consulta consulta) {
		return this.consultaService.save(consulta);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		this.consultaService.delete(id);
	}
	
	@PutMapping
	public Consulta update(@RequestBody Consulta consulta) {
		return this.consultaService.update(consulta);
	}
}

package com.senai.augusto.consultasmedicas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.augusto.consultasmedicas.entidades.Consulta;
import com.senai.augusto.consultasmedicas.service.ConsultaService;

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
    public Consulta criarConsulta(@RequestParam Long medicoId, @RequestParam Long pacienteId, @RequestParam Date data, @RequestParam Integer horario) {
		
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

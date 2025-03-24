package com.senai.augusto.consultasmedicas.controller;

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

import com.senai.augusto.consultasmedicas.entidades.Paciente;
import com.senai.augusto.consultasmedicas.service.PacienteService;

@RestController
@RequestMapping("paciente/")
public class PacienteController {
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping("{id}")
	public Paciente findById(@PathVariable Integer id) {
		return this.pacienteService.findById(id);
	}
	
	@GetMapping
	public List<Paciente> findAll(){
		return this.pacienteService.findAll();
	}
	
	@PostMapping
	public Paciente save(@RequestBody Paciente Paciente) {
		return this.pacienteService.save(Paciente);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		this.pacienteService.delete(id);
	}
	
	@PutMapping
	public Paciente update(@RequestBody Paciente Paciente) {
		return this.pacienteService.update(Paciente);
	}
}

package com.senai.augusto.consultasmedicas.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.augusto.consultasmedicas.dtos.ConsultaDTO;
import com.senai.augusto.consultasmedicas.entidades.Consulta;
import com.senai.augusto.consultasmedicas.service.ConsultaService;

@RestController
@RequestMapping("consulta/")
public class ConsultaController {
	@Autowired
	private ConsultaService consultaService;
	
	@GetMapping("{id}")
	public ConsultaDTO findById(@PathVariable Integer id) {
		return this.consultaService.findById(id);
	}
	
	@GetMapping
	public List<ConsultaDTO> findAll(){
		return this.consultaService.findAll();
	}
	
	@PostMapping
    public ResponseEntity<?> agendarConsulta(@RequestParam Integer medicoId, 
                                             @RequestParam Integer pacienteId,
                                             @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date data, 
                                             @RequestParam Integer horario) {
        try {
            Consulta consulta = consultaService.criarConsulta(medicoId, pacienteId, data, horario);
            return new ResponseEntity<>(consulta, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
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

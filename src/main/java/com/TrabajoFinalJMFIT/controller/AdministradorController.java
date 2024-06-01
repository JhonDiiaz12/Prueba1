package com.TrabajoFinalJMFIT.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.TrabajoFinalJMFIT.entity.Administrador;
import com.TrabajoFinalJMFIT.exception.NotFoundException;
import com.TrabajoFinalJMFIT.repository.AdministradorRepository;

@RestController
@RequestMapping(value = "/api/administrador")

public class AdministradorController {

	@Autowired
	private AdministradorRepository administradorRepository;

	@GetMapping("/")
	public List<Administrador> getAllAdministrador() {
		return administradorRepository.findAll();
	}

	@GetMapping("/{id}")
	public Administrador getCoordinadorById(@PathVariable String id) {
		return administradorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Coordinador no encontrado"));
	}

	@PostMapping("/")
	public Administrador saveCoordinador(@RequestBody Map<String, Object> body) {
		ObjectMapper mapper = new ObjectMapper();
		Administrador administrador = mapper.convertValue(body, Administrador.class);
		return administradorRepository.save(administrador);
	}

	@PutMapping("/{id}")
	public Administrador updateCoordinador(@PathVariable String id, @RequestBody Map<String, Object> body) {
		ObjectMapper mapper = new ObjectMapper();
		Administrador administrador = mapper.convertValue(body, Administrador.class);
		administrador.setId(id);
		return administradorRepository.save(administrador);
	}

	@DeleteMapping("/{id}")
	public Administrador deleteCoordinador(@PathVariable String id) {
		Administrador administrador = administradorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Coordinador no encontrado"));
		administradorRepository.deleteById(id);
		return administrador;
	}
}

package com.TrabajoFinalJMFIT.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.TrabajoFinalJMFIT.entity.Cliente;
import com.TrabajoFinalJMFIT.exception.NotFoundException;
import com.TrabajoFinalJMFIT.repository.ClienteRepository;


@RestController
@RequestMapping(value = "/api/Clientes")
public class ClienteController {
	

	
	    @Autowired
	    private ClienteRepository clienteRepository;

	    @GetMapping("/")
	    public List<Cliente> getAllCliente() {
	        return clienteRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Cliente getClienteById(@PathVariable String id) {
	        return clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente no encontrado"));
	    }

	    @PostMapping("/")
	    public Cliente saveCliente(@RequestBody Map<String, Object> body) {
	        ObjectMapper mapper = new ObjectMapper();
	        Cliente cliente = mapper.convertValue(body, Cliente.class);
	        return clienteRepository.save(cliente);
	    }

	    @PutMapping("/{id}")
	    public Cliente updateCliente(@PathVariable String id, @RequestBody Map<String, Object> body) {
	        ObjectMapper mapper = new ObjectMapper();
	        Cliente cliente = mapper.convertValue(body, Cliente.class);
	        cliente.setId(id);
	        return clienteRepository.save(cliente);
	    }

	    @DeleteMapping("/{id}")
	    public Cliente deleteCliente(@PathVariable String id) {
	    	Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente no encontrado"));
	    	clienteRepository.deleteById(id);
	        return cliente;
	    }
	    
	    @PutMapping("/{usuario}")
	    public Cliente resultCliente(@PathVariable String usuario) {
	        return clienteRepository.findByUsuario(usuario);
	    }
	    @PutMapping("/{id}/actualizarEstadoPlan")
	    public Cliente actualizarEstadoPlan(@PathVariable String id) {
	        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente no encontrado"));
	        cliente.setEstadoPlan("EN ESPERA");
	        return clienteRepository.save(cliente);
	    }

	}



	



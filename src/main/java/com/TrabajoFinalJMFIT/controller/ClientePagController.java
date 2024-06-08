package com.TrabajoFinalJMFIT.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Agregada esta importación
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.TrabajoFinalJMFIT.entity.Cliente;
import com.TrabajoFinalJMFIT.exception.NotFoundException;
import com.TrabajoFinalJMFIT.repository.ClienteRepository;

import jakarta.servlet.http.HttpSession;
@SuppressWarnings("unused")
@Controller // Asegúrate de agregar la anotación @Controller
@RequestMapping("/Clientes")
public class ClientePagController {
	@Autowired
	private ClienteRepository clienteRepository;



	@GetMapping("/")
	public String clienteListTemplate(Model model) {
		model.addAttribute("clientes", clienteRepository.findAll());
		
		return "Clienteform";
	}

	@GetMapping("/new")
	public String clientesNewTemplate(Model model) {
		model.addAttribute("clientes", new Cliente());
		return "Sesion";
	}

	@GetMapping("/edit/{id}")
	public String clienteEditTemplate(@PathVariable("id") String id, Model model) {
		model.addAttribute("clientes",
				clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado")));
		return "Editar";
	}
	@GetMapping("/services/{id}")
	public String mostrarServicios(@PathVariable("id") String id, Model model) {
		model.addAttribute("clientes",
				clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado")));
	 
	    
	    return "services"; // Nombre de la vista para mostrar los servicios
	}
	@GetMapping("/Precios/{id}")
	public String mostrarPrecios(@PathVariable("id") String id, Model model) {
		model.addAttribute("clientes",
				clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado")));
	 
	    
	    return "Precios"; // Nombre de la vista para mostrar los servicios
	}
	@GetMapping("/gallery/{id}")
	public String mostrargallery(@PathVariable("id") String id, Model model) {
		model.addAttribute("clientes",
				clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado")));
	 
	    
	    return "gallery"; // Nombre de la vista para mostrar los servicios
	}
	@GetMapping("/schedule/{id}")
	public String mostrarschedule(@PathVariable("id") String id, Model model) {
		model.addAttribute("clientes",
				clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado")));
	 
	    
	    return "schedule"; // Nombre de la vista para mostrar los servicios
	}
	@GetMapping("/Inicio/{id}")
	public String mostrarInicio(@PathVariable("id") String id, Model model) {
		model.addAttribute("clientes",
				clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado")));
	 
	    
	    return "Inicio"; // Nombre de la vista para mostrar los servicios
	}
	@GetMapping("/about/{id}")
	public String mostrarAbout(@PathVariable("id") String id, Model model) {
		model.addAttribute("clientes",
				clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado")));
	 
	    
	    return "about"; // Nombre de la vista para mostrar los servicios
	}
	@GetMapping("/contact/{id}")
	public String mostrarcontact(@PathVariable("id") String id, Model model) {
		model.addAttribute("clientes",
				clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado")));
	 
	    
	    return "contact"; // Nombre de la vista para mostrar los servicios
	}

	
	@GetMapping("/edit1/{id}")
	public String clienteEditsTemplate(@PathVariable("id") String id, Model model) {
		model.addAttribute("clientes",
				clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado")));
		return "Clientecom";
	}
	@PostMapping("/salvar")
	public String AdminSalvarProcess(@ModelAttribute("cliente") Cliente cliente) {
	    if (cliente.getId().isEmpty()) {
	        cliente.setId(null);
	    }
	    
	    clienteRepository.save(cliente);
	    return "redirect:/Login";
	}
	@PostMapping("/salvar2")
	public String AdminSalvar(@ModelAttribute("cliente") Cliente cliente) {
	    if (cliente.getId().isEmpty()) {
	        cliente.setId(null);
	    }
	    
	    clienteRepository.save(cliente);
	    return "redirect:/Login";
	}
	
	
	
	




	@GetMapping("/delete/{id}")
	
	public String clienteDeleteProcess(@PathVariable("id") String id) {
		clienteRepository.deleteById(id);
		return "redirect:/clientes/";
	}

	@GetMapping("/registro")
	public String registroTemplate(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "registro-estudiante";
	}
	
	@PutMapping("/{id}/actualizarEstadoPlan")
	public String actualizarEstadoPlan(@PathVariable String id) {
	    Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente no encontrado"));
	    cliente.setEstadoPlan("EN ESPERA");
	    clienteRepository.save(cliente);
	    return "redirect:/Clientes/"; // Redirige a la página de clientes después de actualizar el estado del plan
	}
	
	
	@PostMapping("/ingresar")
	public String login(@RequestParam("usuario") String usuario,
	                    @RequestParam("password") String password, 
	                    HttpSession session, Model model) {
	    // Verificar las credenciales
	    Cliente cliente = clienteRepository.findByUsuario(usuario);
	    if (cliente != null && cliente.getPassword().equals(password)) {
	        // Si las credenciales son válidas, almacenar el ID en el modelo
	        model.addAttribute("id", cliente.getId());
	        // Redirigir a la página de inicio
	        return "Inicio";
	    } else { 
	        // Inicio de sesión fallido, mostrar mensaje de error en la página de inicio de sesión
	        model.addAttribute("authenticationFailed", true);
	        model.addAttribute("errorMessage", "Usuario o contraseña incorrectos");
	        return "Login";
	    }
	}




	


	}



	



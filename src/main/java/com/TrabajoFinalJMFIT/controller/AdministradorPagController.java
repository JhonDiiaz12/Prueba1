package com.TrabajoFinalJMFIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Agregada esta importación
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TrabajoFinalJMFIT.entity.Administrador;
import com.TrabajoFinalJMFIT.exception.NotFoundException;
import com.TrabajoFinalJMFIT.repository.AdministradorRepository;


@Controller // Asegúrate de agregar la anotación @Controller
@RequestMapping("/administrador")
public class AdministradorPagController {


		@Autowired
		private AdministradorRepository administradorRepository;

		@GetMapping("/")
		public String CoordinadorListTemplate(Model model) {
			model.addAttribute("administrador", administradorRepository.findAll());
			return "Aminform";
		}

		@GetMapping("/new")
		public String coordinadoresNewTemplate(Model model) {
			model.addAttribute("administrador", new Administrador());
			return "Admincrear";
		}

		@GetMapping("/edit/{id}")
		public String CoordinadorEditTemplate(@PathVariable("id") String id, Model model) {
			model.addAttribute("administrador", administradorRepository.findById(id)
					.orElseThrow(() -> new NotFoundException("Coordinador no encontrado")));
			return "Admincrear";
		}

		@PostMapping("/save")
		public String coordinadoresSaveProcess(@ModelAttribute("usuario") Administrador administrador) {
			if (administrador.getId().isEmpty()) {
				administrador.setId(null);
			}
			administradorRepository.save(administrador);
			return "redirect:/InicioAdmin/";
		}

		@PostMapping("/salvar")
		public String CoordinadoresSalvarProcess(@ModelAttribute("usuario") Administrador administrador) {
			if (administrador.getId().isEmpty()) {
				administrador.setId(null);
			}
			administradorRepository.save(administrador);
			return "redirect:/administrador/";
		}

		@GetMapping("/delete/{id}")
		public String coordinadoresDeleteProcess(@PathVariable("id") String id) {
			administradorRepository.deleteById(id);
			return "redirect:/administrador/";
		}

		@GetMapping("/registro")
		public String registroTemplate(Model model) {
			model.addAttribute("coordinador", new Administrador());
			return "registro-coordinador";
		}


		@PostMapping("/ingresar")
		public String login(@RequestParam("usuario") String usuario, @RequestParam("password") String password, Model model) {
			// Verificar las credenciales
			System.out.println("Usuario: " + usuario + " Password:" + password);

			List<Administrador> administradorList = administradorRepository.findAll();
			System.out.println(administradorList.get(0).getUsuario());
			Administrador administrador = administradorRepository.findByUsuarioAndPassword(usuario, password);
			if (administrador != null) {
				// Inicio de sesión exitoso, redirigir a la página de inicio
				System.out.println("Usuario: " + administrador.getUsuario() + " Password:" + administrador.getPassword());
				return "InicioAdmin"; // Nombre de la página de inicio (por ejemplo, "inicio.html")
			} else {
				// Inicio de sesión fallido, mostrar mensaje de error en la página de inicio
				model.addAttribute("authenticationFailed", true);
				model.addAttribute("errorMessage", "Usuario o contraseña incorrectos");
				return "Login";
			}
		}
	}

	
	
	


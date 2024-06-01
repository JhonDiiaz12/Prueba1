package com.TrabajoFinalJMFIT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Precios")
public class PreciosController {

	
	 @GetMapping("/")
	    public String defaultHome(Model model) {
	        return "Precios";
	    }
}

package com.escolacrud.escolacrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MatriculaController {

	@RequestMapping("/matricular")
	public String form() {
		return "formulario";
	}
}

package com.escolacrud.escolacrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.escolacrud.escolacrud.models.Matricula;
import com.escolacrud.repository.EscolaRepository;

@Controller
public class MatriculaController {

	@Autowired
	private EscolaRepository er;
	
	@RequestMapping(value="/matricularAluno", method=RequestMethod.GET)
	public String form() {
		return "formulario";
	}
	
	@RequestMapping(value="/matricularAluno", method=RequestMethod.POST)
	public String form(Matricula matricula) {
		
		er.save(matricula);
		return "formulario";
	}
	
	@RequestMapping("matriculas")
	public ModelAndView matriculas() {
		ModelAndView mv = new ModelAndView("matriculas");
		Iterable<Matricula> matriculas = er.findAll();
		mv.addObject("matriculas", matriculas);
		return mv;
	}
	
	//Deletar//
	@RequestMapping("/deletarMatricula")
	public String deletarMatricula(@PathVariable("codigo") long codigo) {
	   Matricula matricula = er.findByCodigo(codigo);
	   er.delete(matricula);
	   return "redirect:/matriculas";
	}//
	
}

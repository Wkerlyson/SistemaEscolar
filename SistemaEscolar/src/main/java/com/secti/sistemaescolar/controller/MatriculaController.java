package com.secti.sistemaescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.secti.sistemaescolar.repository.TurmaRepository;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {
	
	@Autowired
	private TurmaRepository tr;
		
	@GetMapping("turma/{id}")
	public ModelAndView dadosTurma(@PathVariable  Long id) {
		ModelAndView modelAndView = new ModelAndView("turmas/matricula-turma");
		modelAndView.addObject("turma", tr.findOne(id));
		return modelAndView;
	}
}

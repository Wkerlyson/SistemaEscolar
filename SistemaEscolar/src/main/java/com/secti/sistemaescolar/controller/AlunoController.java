package com.secti.sistemaescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.secti.sistemaescolar.model.Aluno;
import com.secti.sistemaescolar.repository.AlunoRepository;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoRepository ar; 
	
	@GetMapping("/novo")
	public ModelAndView novoAluno(Aluno aluno) {
		ModelAndView modelAndView = new ModelAndView("alunos/cadastro-aluno");
		modelAndView.addObject(aluno);
		
		return modelAndView;
	}
	
	@GetMapping
	public ModelAndView listarAlunos() {
		ModelAndView modelAndView = new ModelAndView("alunos/lista-alunos");
		modelAndView.addObject("alunos", ar.findAll());
		
		return modelAndView;
	}
}

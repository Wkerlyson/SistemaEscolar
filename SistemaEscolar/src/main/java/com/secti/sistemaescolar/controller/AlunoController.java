package com.secti.sistemaescolar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@PostMapping("/novo")
	public ModelAndView salvarAluno(@Valid Aluno aluno, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novoAluno(aluno);
		}
		

		ar.save(aluno);
		
		attributes.addFlashAttribute("mensagem", "Aluno Cadastrado com sucesso");
		
		return new ModelAndView("redirect:/alunos/novo");
	}
	
	@GetMapping
	public ModelAndView listarAlunos() {
		ModelAndView modelAndView = new ModelAndView("alunos/lista-alunos");
		modelAndView.addObject("alunos", ar.findAll());
		
		return modelAndView;
	}
	
	@PostMapping("/edicao")
	public ModelAndView edicaoAluno(@Valid Aluno aluno, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novoAluno(aluno);
		}
				
		ar.save(aluno);
		
		attributes.addFlashAttribute("mensagem", "Dados do aluno atualizados com sucesso");
		
		return new ModelAndView("redirect:/alunos/");
	}
	
	@GetMapping("/{id}")
	public ModelAndView editarAluno(@PathVariable  Long id) {
		ModelAndView modelAndView = new ModelAndView("alunos/edicao-aluno");
		modelAndView.addObject(ar.findOne(id));
		
		return modelAndView;
	}
}

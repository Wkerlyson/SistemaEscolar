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

import com.secti.sistemaescolar.model.Turma;
import com.secti.sistemaescolar.model.Turno;
import com.secti.sistemaescolar.repository.DisciplinaRepository;
import com.secti.sistemaescolar.repository.TurmaRepository;

@Controller
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	private TurmaRepository tr;
	
	@Autowired
	private DisciplinaRepository dr;
	
	@GetMapping("/novo")
	public ModelAndView novaTurma(Turma turma) {
		ModelAndView modelAndView = new ModelAndView("turmas/cadastro-turma");
		modelAndView.addObject(turma);
		modelAndView.addObject("turnos", Turno.values());
		modelAndView.addObject("disciplinas", dr.findAll());
		
		return modelAndView;
		
	}
	
	@PostMapping("/novo")
	public ModelAndView salvarTurma(@Valid Turma turma, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novaTurma(turma);
		}
		

		tr.save(turma);
		
		attributes.addFlashAttribute("mensagem", "Turma Cadastrado com sucesso");
		
		return new ModelAndView("redirect:/turmas/novo");
	}
	
	@GetMapping
	public ModelAndView listarTurmas() {
		ModelAndView modelAndView = new ModelAndView("turmas/lista-turmas");
		modelAndView.addObject("turmas", tr.findAll());
		return modelAndView;
	}
	
	@PostMapping("/edicao")
	public ModelAndView edicaoTurma(@Valid Turma turma, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novaTurma(turma);
		}
				
		tr.save(turma);
		
		attributes.addFlashAttribute("mensagem", "Dados da turma atualizados com sucesso");
		
		return new ModelAndView("redirect:/turmas/");
	}
	
	@GetMapping("/{id}")
	public ModelAndView editarTurma(@PathVariable  Long id) {
		ModelAndView modelAndView = new ModelAndView("turmas/edicao-turma");
		modelAndView.addObject(tr.findOne(id));
		modelAndView.addObject("turnos", Turno.values());
		modelAndView.addObject("disciplinas", dr.findAll());
		
		return modelAndView;
	}
	
	
}

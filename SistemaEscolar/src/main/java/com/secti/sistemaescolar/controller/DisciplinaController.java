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

import com.secti.sistemaescolar.model.Disciplina;
import com.secti.sistemaescolar.repository.DisciplinaRepository;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {
	
	@Autowired
	DisciplinaRepository dr;
	
	@GetMapping
	public ModelAndView novaDisciplina(Disciplina disciplina) {
		ModelAndView modelAndView = new ModelAndView("disciplinas/disciplinas");
		modelAndView.addObject(disciplina);
		modelAndView.addObject("disciplinas", dr.findAll());
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView salvarAluno(@Valid Disciplina disciplina, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novaDisciplina(disciplina);
		}
		

		dr.save(disciplina);
		
		attributes.addFlashAttribute("mensagem", "Disciplina cadastrada com sucesso");
		
		return new ModelAndView("redirect:/disciplinas");
	}
	
	@GetMapping("/{id}")
	public ModelAndView editarDisciplina(@PathVariable  Long id) {
		ModelAndView modelAndView = new ModelAndView("disciplinas/disciplinas");
		modelAndView.addObject(dr.findOne(id));
		modelAndView.addObject(dr.findAll());
		return modelAndView;
	}
	
}

package com.secti.sistemaescolar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.secti.sistemaescolar.model.Aluno;
import com.secti.sistemaescolar.model.Matricula;
import com.secti.sistemaescolar.repository.AlunoRepository;
import com.secti.sistemaescolar.repository.MatriculaRepository;
import com.secti.sistemaescolar.repository.TurmaRepository;

@Controller
@RequestMapping("turma/matricula")
public class MatriculaController {
	
	@Autowired
	private TurmaRepository tr;
	
	@Autowired
	private AlunoRepository ar;
	
	@Autowired
	private MatriculaRepository mr;
	
			
	@GetMapping("/{id}")
	public ModelAndView dadosTurma(@PathVariable  Long id, Aluno aluno, Matricula matricula, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("matricula/matricula");
		modelAndView.addObject(matricula);
		modelAndView.addObject(aluno);
		modelAndView.addObject("turma", tr.findOne(id));
		return modelAndView;
	}
	
	
	
	@GetMapping("{id}/busca-aluno")
	public ModelAndView buscaAluno(@PathVariable  Long id, @RequestParam("id") Long idAluno, Aluno aluno, Matricula matricula, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("matricula/matricula");
		modelAndView.addObject(matricula);
		modelAndView.addObject(aluno);
		modelAndView.addObject("turma", tr.findOne(id));
		modelAndView.addObject("alunos", ar.findOne(idAluno));
		return modelAndView;
	}
	

	@PostMapping("/nova")
	public ModelAndView salvarMatricula(@Valid Matricula matricula, @PathVariable  Long idTurma, BindingResult result, RedirectAttributes attributes) {
		
		matricula.setTurma(tr.findOne(1L));
		
//		if (result.hasErrors()) {
//			return novaTurma(turma);
//		}
		
		mr.save(matricula);
		
		attributes.addFlashAttribute("mensagem", "Matrícula efetuada com sucesso");
		
		return new ModelAndView("redirect:/turmas/");
	}
}

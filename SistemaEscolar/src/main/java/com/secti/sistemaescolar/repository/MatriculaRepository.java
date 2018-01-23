package com.secti.sistemaescolar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.secti.sistemaescolar.model.Aluno;
import com.secti.sistemaescolar.model.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	List<Aluno> findAlunoById(Long id);
}

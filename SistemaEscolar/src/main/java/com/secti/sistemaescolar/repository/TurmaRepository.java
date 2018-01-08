package com.secti.sistemaescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.secti.sistemaescolar.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{

}

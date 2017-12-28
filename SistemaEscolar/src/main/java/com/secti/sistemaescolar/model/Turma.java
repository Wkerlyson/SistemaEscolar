package com.secti.sistemaescolar.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_turma")
	private Long id;
	
	@NotBlank
	@Column(name = "nome_turma")
	private String nomeTurma;
	
	@NotNull
	private Turno turno;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ano_letivo")
	private Date anoLetivo;

	@OneToMany(mappedBy = "id.turma")
	private List<TurmaAluno> turmaAlunos; 
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "turma_disciplina", joinColumns = @JoinColumn(name = "id_turma", referencedColumnName = "id_turma"),
			inverseJoinColumns = @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina"))  
	private List<Disciplina> disciplinas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Date getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(Date anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	
	

	public List<TurmaAluno> getTurmaAlunos() {
		return turmaAlunos;
	}

	public void setTurmaAlunos(List<TurmaAluno> turmaAlunos) {
		this.turmaAlunos = turmaAlunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}

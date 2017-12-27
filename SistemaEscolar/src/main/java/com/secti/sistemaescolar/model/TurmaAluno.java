package com.secti.sistemaescolar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class TurmaAluno {
	
	@EmbeddedId
	private TurmaAlunoId id;
	
	@NotNull
	@Column(name = "data_matricula")
	private Date dataMatricula;
	
	@NotNull
	@Column(name = "situacao_aluno")
	private SituacaoAluno situacaoAluno;

	public TurmaAlunoId getId() {
		return id;
	}

	public void setId(TurmaAlunoId id) {
		this.id = id;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public SituacaoAluno getSituacaoAluno() {
		return situacaoAluno;
	}

	public void setSituacaoAluno(SituacaoAluno situacaoAluno) {
		this.situacaoAluno = situacaoAluno;
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
		TurmaAluno other = (TurmaAluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

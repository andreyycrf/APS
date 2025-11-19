package edu.ifpb.webII.model;

import java.util.List; 
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="Matricula")
public class Matricula {
	
	@EmbeddedId
	private MatriculaID id;
	
	@ManyToOne
	@MapsId("matricula_aluno")
	@JoinColumn(name="matricula_aluno")
	private Aluno aluno;
	
	@ManyToOne
	@MapsId("cod_disciplina")
	@JoinColumn(name="cod_disciplina")
	private Disciplina disciplina;
	
	//O mapeamento já foi feito na pk
	@Column(name="periodo_matricula", insertable=false, updatable=false)
	private String periodo;
	
	public Matricula(){}

	public Matricula(MatriculaID id, Aluno aluno, Disciplina disciplina, String periodo) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.periodo = periodo;
	}

	public MatriculaID getId() {
		return id;
	}

	public void setId(MatriculaID id) {
		this.id = id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, disciplina, periodo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(disciplina, other.disciplina)
				&& Objects.equals(periodo, other.periodo);
	}


	
}

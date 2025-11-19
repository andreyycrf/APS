package edu.ifpb.webII.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="disciplina")
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="disciplina_seq")
	@SequenceGenerator(name="disciplina_seq", sequenceName="disciplina_seq",allocationSize=1)
	private Long codigo;
	
	@Column
	private String nome;
	
	@Column
	private Long carga_horaria;
	
	@ManyToOne
	@JoinColumn(name="cod_curso")
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="cod_prof")
	private Professor professor;
	
	@OneToMany(mappedBy = "disciplina")
	private List<Matricula> alunos;


	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCarga_horaria() {
		return carga_horaria;
	}

	public void setCarga_horaria(Long carga_horaria) {
		this.carga_horaria = carga_horaria;
	}


	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	public List<Matricula> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Matricula> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
}

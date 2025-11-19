package edu.ifpb.webII.model;

import java.util.List;  
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="Aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="aluno_seq")
	@SequenceGenerator(name="aluno_seq", sequenceName="aluno_seq",allocationSize=1)
	private Long matricula;
	
	@Column
	private String nome;

	@Embedded
	private Endereco endereco;
	
	
	@ManyToOne
	@JoinColumn(name="cod_curso")
	private Curso curso;
	
	@OneToMany(mappedBy = "aluno")
	private List<Matricula> disciplinas;

	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public List<Matricula> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Matricula> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public String getNome() {
		return nome; 
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}
	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + "]";
	}
	
	
	
	
	

}

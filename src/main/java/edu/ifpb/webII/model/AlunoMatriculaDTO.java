package edu.ifpb.webII.model;

import java.util.List;
import java.util.Objects;

public class AlunoMatriculaDTO {
	
	private Long matricula;
	
	private List<Disciplina> disciplinas;
	
	private String periodo ;
	
	public AlunoMatriculaDTO(Long matricula, List<Disciplina> disciplinas, String periodo) {
		super();
		this.matricula = matricula;
		this.disciplinas = disciplinas;
		this.periodo = periodo;
	}
	
	public AlunoMatriculaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	@Override
	public int hashCode() {
		return Objects.hash(disciplinas, matricula, periodo);
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoMatriculaDTO other = (AlunoMatriculaDTO) obj;
		return Objects.equals(disciplinas, other.disciplinas) && Objects.equals(matricula, other.matricula)
				&& Objects.equals(periodo, other.periodo);
	}
	
	
	
}

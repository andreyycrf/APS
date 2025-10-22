package ifpb.aps.ws.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="aluno_seq")
	@SequenceGenerator(name="aluno_seq", sequenceName="aluno_seq", allocationSize=1)
	private Long matricula;
	
	@Column
	private String nome;
	
	@Embedded
	private Endereco endereco;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_resp", referencedColumnName = "id_resp")
	private Responsavel responsavel;
	
	@ManyToOne
	@JoinColumn(name="cod_curso")
	private Curso curso;
	
	@ManyToMany
	@JoinTable(
	    name = "aluno_professor",
	    joinColumns = { @JoinColumn(name = "matricula_aluno") },
	    inverseJoinColumns = { @JoinColumn(name = "matricula_professor") }
	)
	private List<Professor> professores;

	@OneToMany(mappedBy = "aluno")
	private List<Matricula> cursos;

	@Column
	public Long getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass());
		return false;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
}

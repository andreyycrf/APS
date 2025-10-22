package ifpb.aps.ws.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Responsavel")
public class Responsavel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="responsavel_seq")
	@SequenceGenerator(name="responsavel_seq", sequenceName="responsavel_seq", allocationSize=1)
	private Long id_resp;
	
	@Column
	private String nome;
	
	@Column
	private String telefone;

	public Long getId_resp() {
		return id_resp;
	}

	public void setId_resp(Long id_resp) {
		this.id_resp = id_resp;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}


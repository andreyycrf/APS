package ifpb.aps.ws.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MatriculaID implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "matricula_aluno")
    private Long matricula_aluno;

    @Column(name = "cod_disciplina")
    private Long cod_disciplina;

    @Column(name = "periodo_matricula")
    private String periodo_matricula;

    @SuppressWarnings("unused")
    private MatriculaID() {}

    public MatriculaID(Long matricula_aluno, Long cod_disciplina, String periodo_matricula) {
        super();
        this.matricula_aluno = matricula_aluno;
        this.cod_disciplina = cod_disciplina;
        this.periodo_matricula = periodo_matricula;
    }

    // Getters e Setters
    public Long getMatricula_aluno() {
        return matricula_aluno;
    }

    public void setMatricula_aluno(Long matricula_aluno) {
        this.matricula_aluno = matricula_aluno;
    }

    public Long getCod_disciplina() {
        return cod_disciplina;
    }

    public void setCod_disciplina(Long cod_disciplina) {
        this.cod_disciplina = cod_disciplina;
    }

    public String getPeriodo_matricula() {
        return periodo_matricula;
    }

    public void setPeriodo_matricula(String periodo_matricula) {
        this.periodo_matricula = periodo_matricula;
    }
}
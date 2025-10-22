package ifpb.aps.ws.model;
import jakarta.persistence.Entity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;

public class Matricula {
    @EmbeddedId
    private MatriculaID id;

    @ManyToOne
    @MapsId("matricula")
    @JoinColumn(name = "matricula_aluno")
    private Aluno aluno;

    @ManyToOne
    @MapsId("codigo")
    @JoinColumn(name = "cod_disciplina")
    private Disciplina disciplina;

    @Column(name = "periodo_matricula", insertable = false, updatable = false)
    private String periodo;

    public Matricula() {}

    public Matricula(MatriculaID id, Aluno aluno, Disciplina disciplina, String periodo) {
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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
package ifpb.aps.ws.model;

import jakarta.persistence.*;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int cargaHoraria;
    private String curso;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professorResponsavel;

    public Curso() {}

    public Curso(String nome, int cargaHoraria, String curso, Professor professorResponsavel) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.curso = curso;
        this.professorResponsavel = professorResponsavel;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }
}


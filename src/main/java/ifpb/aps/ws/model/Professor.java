package ifpb.aps.ws.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="professor_seq")
    @SequenceGenerator(name="professor_seq", sequenceName="professor_seq", allocationSize=1)
    private Long matricula;

     @Column
    private String nome;

     @Column
    private String area;

    @ManyToMany(mappedBy = "professores")
    @JsonIgnore
    private List<Aluno> alunos;

    public Professor() {}

    public Professor(String matricula, String nome, String area) {
        this.matricula = matricula;
        this.nome = nome;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

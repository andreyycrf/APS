package ifpb.aps.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ifpb.aps.ws.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno , Long> { 

}

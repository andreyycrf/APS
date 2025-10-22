package ifpb.aps.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ifpb.aps.ws.model.Curso;

@Repository
public interface DisciplinaRepository extends JpaRepository<Curso, Long> {
}

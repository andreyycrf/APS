package ifpb.aps.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ifpb.aps.ws.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
 
    


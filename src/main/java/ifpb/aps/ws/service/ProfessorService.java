package ifpb.aps.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.aps.ws.model.Professor;
import ifpb.aps.ws.repository.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listarProfessores() {
        return professorRepository.findAll();
    }

    public Professor cadastrarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor atualizarProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deletarProfessor(Long id) {
        professorRepository.deleteById(id);
    }
}


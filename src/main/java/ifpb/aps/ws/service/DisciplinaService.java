package ifpb.aps.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.aps.ws.model.Curso;
import ifpb.aps.ws.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Curso> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Curso cadastrarDisciplina(Curso disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Curso atualizarDisciplina(Curso disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public void deletarDisciplina(Long id) {
        disciplinaRepository.deleteById(id);
    }
}

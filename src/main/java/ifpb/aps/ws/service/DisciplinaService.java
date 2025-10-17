package ifpb.aps.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifpb.aps.ws.model.Disciplina;
import ifpb.aps.ws.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina cadastrarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public void deletarDisciplina(Long id) {
        disciplinaRepository.deleteById(id);
    }
}

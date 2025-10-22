package ifpb.aps.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ifpb.aps.ws.model.Curso;
import ifpb.aps.ws.service.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public List<Curso> listarDisciplinas() {
        return disciplinaService.listarDisciplinas();
    }

    @PostMapping
    public Curso cadastrarDisciplina(@RequestBody Curso disciplina) {
        return disciplinaService.cadastrarDisciplina(disciplina);
    }

    @PutMapping
    public Curso atualizarDisciplina(@RequestBody Curso disciplina) {
        return disciplinaService.atualizarDisciplina(disciplina);
    }

    @DeleteMapping("/{id}")
    public void deletarDisciplina(@PathVariable Long id) {
        disciplinaService.deletarDisciplina(id);
    }
}


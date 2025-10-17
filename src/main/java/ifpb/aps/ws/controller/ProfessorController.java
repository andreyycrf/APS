package ifpb.aps.ws.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ifpb.aps.ws.model.Professor;
import ifpb.aps.ws.service.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    // Listar todos os professores
    @GetMapping
    public List<Professor> listarProfessores() {
        return professorService.listarProfessores();
    }

    // Cadastrar novo professor
    @PostMapping
    public Professor cadastrarProfessor(@RequestBody Professor professor) {
        return professorService.cadastrarProfessor(professor);
    }

    // Atualizar informações de um professor
    @PutMapping
    public Professor atualizarProfessor(@RequestBody Professor professor) {
        return professorService.atualizarProfessor(professor);
    }

    // Deletar professor pelo id (ou matrícula)
    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id) {
        professorService.deletarProfessor(id);
    }
}
 
    


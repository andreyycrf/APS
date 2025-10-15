package ifpb.aps.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifpb.aps.ws.model.Aluno;
import ifpb.aps.ws.service.AlunoService;

@RestController
@RequestMapping("/alunos")

public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	@GetMapping
	public List<Aluno> listarAlunos() {
		return alunoService.listarAlunos();
	}
	@PostMapping
	public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
		return alunoService.cadastarAluno(aluno);
	}
	@PutMapping
	public Aluno atualizarAluno(@RequestBody Aluno aluno) {
		return alunoService.cadastarAluno(aluno);
	}


}

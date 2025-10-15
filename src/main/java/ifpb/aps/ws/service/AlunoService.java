package ifpb.aps.ws.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ifpb.aps.ws.model.Aluno;
import ifpb.aps.ws.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Aluno> listarAlunos() {
		return alunoRepository.findAll();
	}
	public Aluno cadastarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
		
	}
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	public Long deletarAluno(Aluno alunorequest) {
		alunoRepository.deleteById(alunorequest.getMatricula());
		return (long) 0;
	}

}

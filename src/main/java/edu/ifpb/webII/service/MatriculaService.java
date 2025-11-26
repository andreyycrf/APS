package edu.ifpb.webII.model.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ifpb.webII.model.Aluno;
import edu.ifpb.webII.model.Disciplina;
import edu.ifpb.webII.model.Matricula;
import edu.ifpb.webII.model.MatriculaID;
import edu.ifpb.webII.repository.DisciplinaRepository;
import edu.ifpb.webII.repository.MatriculaRepository;


@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Transactional(readOnly = true)
	public List<Matricula> listarMatriculas(){
		return matriculaRepository.findAll();
	}

	@Transactional(readOnly = false)
	public List<Matricula> cadastrarMatricula(List<Matricula> matriculas) {
		return matriculaRepository.saveAll(matriculas);
	}

	@Transactional(readOnly = false)
	public Matricula atualizarMatricula(Matricula matricula) {
		return matriculaRepository.save(matricula);
	}

	@Transactional(readOnly = true)
	public Matricula listarMatricula(MatriculaID matriculaID) {
		Matricula matricula = (Matricula) matriculaRepository.findById(matriculaID).orElse(null);
		return matricula;
	}
	
	@Transactional(readOnly = false)
	public String deletarMatricula(Matricula matricula) {
		MatriculaID matriculaID = matricula.getId();
		matriculaRepository.deleteById(matriculaID);
		return "Matricula " + matricula + " deletado com sucesso";
	}
	
	@Transactional(readOnly = true)
	public Map<String,List<Disciplina>> buscarDisciplinasporPeriodo(Aluno aluno){
		List<Matricula> alunoMatricula = matriculaRepository.findByAluno(aluno);

		Map<String, List<Disciplina>> disciplinasPorPeriodo = alunoMatricula.stream()
				.collect(Collectors.groupingBy(Matricula::getPeriodo,
						Collectors.mapping(Matricula::getDisciplina, Collectors.toList())));
		return disciplinasPorPeriodo;
	}

	@Transactional(readOnly = false)
	public String deletarMatriculaID(MatriculaID matriculaID) {
		matriculaRepository.deleteById(matriculaID);
		return "Matricula de codigo " + matriculaID + " deletada com sucesso";		
	}

}

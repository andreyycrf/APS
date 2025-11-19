package edu.ifpb.webII.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ifpb.webII.model.Aluno;
import edu.ifpb.webII.model.AlunoMatriculaDTO;
import edu.ifpb.webII.model.Curso;
import edu.ifpb.webII.model.Disciplina;
import edu.ifpb.webII.model.Matricula;
import edu.ifpb.webII.model.MatriculaID;
import edu.ifpb.webII.model.service.AlunoService;
import edu.ifpb.webII.model.service.DisciplinaService;
import edu.ifpb.webII.model.service.MatriculaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(ModelMap model) {
		model.addAttribute("alunoMatricula", new AlunoMatriculaDTO());
		return "/matriculas/cadastro";
	} 
	
	@PostMapping("/salvar")
	public String salvar(AlunoMatriculaDTO alunoMatricula, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "matriculas/cadastro";
		}
		List<Matricula> matriculas = new ArrayList<Matricula>();
		for (Disciplina disciplina : alunoMatricula.getDisciplinas()) {
			MatriculaID matriculaID = new MatriculaID(alunoMatricula.getMatricula(), disciplina.getCodigo(),alunoMatricula.getPeriodo());
			Aluno aluno = alunoService.listarAluno(alunoMatricula.getMatricula());
			Matricula matricula = new Matricula(matriculaID, aluno, disciplina,alunoMatricula.getPeriodo());
			matriculas.add(matricula);
		}
		matriculaService.cadastrarMatricula(matriculas);
		attr.addFlashAttribute("sucesso", "Matricula salva com sucesso!");
		return "redirect:/matriculas/cadastrar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		Map<String, List<Disciplina>> disciplinasPorPeriodo = matriculaService.buscarDisciplinasporPeriodo(alunoService.listarAluno(Long.valueOf(2)));
		model.addAttribute("disciplinasPorPeriodo", disciplinasPorPeriodo);
		return "/matriculas/lista";
	}
	
	
	@GetMapping("/editar/{matricula}")
	public String preEditar(@PathVariable("matricula") MatriculaID matriculaID, ModelMap model) {
		Matricula matricula = matriculaService.listarMatricula(matriculaID);
		model.addAttribute("matricula", matricula);
		return "/matriculas/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Matricula matricula, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "matriculas/cadastro";
		}
		matriculaService.atualizarMatricula(matricula);
		attr.addFlashAttribute("sucesso", "Matricula editada com sucesso!");
		return "redirect:/matriculas/cadastrar";
	}
	
	@GetMapping("excluir/{matricula}")
	public String excluir(@PathVariable("matricula") MatriculaID matriculaID, ModelMap model) {
		matriculaService.deletarMatriculaID(matriculaID);
		model.addAttribute("sucesso","Matricula excluída com sucesso!");
		return listar(model);
	} 
	
	@ModelAttribute("listaDisciplinas")
	public List<Disciplina> getDisciplinas(){
		return disciplinaService.listarDisciplinas();
	}
	
}

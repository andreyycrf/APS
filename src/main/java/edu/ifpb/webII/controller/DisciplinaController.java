package edu.ifpb.webII.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ifpb.webII.util.PaginacaoUtil;

import edu.ifpb.webII.model.Curso;
import edu.ifpb.webII.model.Disciplina;
import edu.ifpb.webII.model.Professor;
import edu.ifpb.webII.model.service.CursoService;
import edu.ifpb.webII.model.service.DisciplinaService;
import edu.ifpb.webII.model.service.ProfessorService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Disciplina disciplina) {
		return "/disciplinas/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Disciplina disciplina, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "disciplinas/cadastro";
		}
		disciplinaService.cadastrarDisciplina(disciplina);
		attr.addFlashAttribute("sucesso", "Disciplina salva com sucesso!");
		return "redirect:/disciplinas/cadastrar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model, @RequestParam("page") Optional<Integer> page) {
		int paginaAtual = page.orElse(1);
		PaginacaoUtil<Disciplina> pageDisciplina = disciplinaService.buscarPorPagina(paginaAtual);
		model.addAttribute("pageDisciplina", pageDisciplina);
		return "/disciplinas/lista";
	}
	
	
	@GetMapping("/editar/{codigo}")
	public String preEditar(@PathVariable("codigo") Long codigo, ModelMap model) {
		Disciplina disciplina = disciplinaService.listarDisciplina(codigo);
		model.addAttribute("disciplina", disciplina);
		return "/disciplinas/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Disciplina disciplina, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "disciplinas/cadastro";
		}
		disciplinaService.atualizarDisciplina(disciplina);
		attr.addFlashAttribute("sucesso", "Disciplina editada com sucesso!");
		return "redirect:/disciplinas/cadastrar";
	}
	@GetMapping("excluir/{codigo}")
	public String excluir(@PathVariable("codigo") Long codigo, ModelMap model) {
		disciplinaService.deletarDisciplinaID(codigo);
		model.addAttribute("sucesso","Disciplina excluída com sucesso!");
		return "redirect:/disciplinas/listar";
	}

	@ModelAttribute("cursos")
	public List<Curso> getCursos(){
		return cursoService.listarCursos();
	}
	
	@ModelAttribute("professores")
	public List<Professor> getProfessores(){
		return professorService.listarProfessores();
	}
}

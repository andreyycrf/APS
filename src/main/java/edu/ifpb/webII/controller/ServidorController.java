package edu.ifpb.webII.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.ifpb.webII.model.Servidor;
import edu.ifpb.webII.model.service.ServidorService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/servidores")
public class ServidorController {

    @Autowired
    private ServidorService servidorService;

    @GetMapping("/cadastrar")
    public String cadastrar(Servidor servidor) {
        return "/servidores/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Servidor servidor, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/servidores/cadastro";
        }
        servidorService.salvar(servidor);
        attr.addFlashAttribute("sucesso", "Servidor cadastrado com sucesso!");
        return "redirect:/servidores/listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        List<Servidor> servidores = servidorService.listarTodos();
        model.addAttribute("servidores", servidores);
        return "/servidores/lista";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        Servidor servidor = servidorService.buscarPorId(id);
        model.addAttribute("servidor", servidor);
        return "/servidores/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Servidor servidor, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/servidores/cadastro";
        }
        servidorService.salvar(servidor);
        attr.addFlashAttribute("sucesso", "Servidor editado com sucesso!");
        return "redirect:/servidores/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        servidorService.deletar(id);
        attr.addFlashAttribute("sucesso", "Servidor excluído com sucesso!");
        return "redirect:/servidores/listar";
    }
}

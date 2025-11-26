package edu.ifpb.webII.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servidor")
public class ServidorController {

    @PreAuthorize("hasAnyAuthority('COORDENADOR', 'ADMIN')")
    @GetMapping
    public String listarServidores(Model model) {
        // placeholder: adicionar lógica real
        return "servidores/lista";
    }
}

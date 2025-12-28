package com.juan.sistema_ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.juan.sistema_ticket.enums.RolEnum;
import com.juan.sistema_ticket.model.Usuario;
import com.juan.sistema_ticket.service.ClienteService;

@Controller
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping ("/nuevo-cliente")
    public String nuevoCliente (Model model){
        model.addAttribute("cliente", new Usuario());
        return "nuevo-cliente";
    }

    @PostMapping ("/guardar-cliente")
    public String guardarCliente (@ModelAttribute Usuario cliente){
        cliente.setRol(RolEnum.CLIENTE);
        clienteService.guardarCliente(cliente);
        return "panel";
    }
}

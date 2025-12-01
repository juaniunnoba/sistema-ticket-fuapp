package com.juan.sistema_ticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NuevoTicketController {
    
    @GetMapping ("/nuevo-ticket")
    public String nuevoTicket (){
        return "nuevo-ticket";
    }

    @PostMapping ("/crear-ticket")
    public String crearTicket (){
        return "panel";
    }
}

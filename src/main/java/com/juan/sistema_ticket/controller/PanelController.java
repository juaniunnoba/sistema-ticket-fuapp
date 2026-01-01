package com.juan.sistema_ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.juan.sistema_ticket.service.TicketService;

@Controller
public class PanelController {
    
    @Autowired
    TicketService ticketService;

    @GetMapping ("/panel")
    public String panel (Model model){
        model.addAttribute("ticketsPendientes", ticketService.listarAbiertos());
        return "panel";
    }
}

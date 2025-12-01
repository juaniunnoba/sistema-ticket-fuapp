package com.juan.sistema_ticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistorialTicketsController {
      
    @GetMapping ("/historial-tickets")
    public String historialTickets (){
        return "historial-tickets";
    }
}

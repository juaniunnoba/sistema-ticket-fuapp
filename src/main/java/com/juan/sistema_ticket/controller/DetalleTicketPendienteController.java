package com.juan.sistema_ticket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetalleTicketPendienteController {
    
    @GetMapping ("/detalle-ticket")
    public String detalleTicket (){
        return "detalle-ticket-pendiente";
    }
}

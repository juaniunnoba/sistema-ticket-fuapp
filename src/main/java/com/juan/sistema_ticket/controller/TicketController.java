package com.juan.sistema_ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.juan.sistema_ticket.model.Ticket;
import com.juan.sistema_ticket.service.TicketService;

@Controller
public class TicketController {
    
    @Autowired
    private TicketService ticketService;

    @GetMapping ("/nuevo-ticket")
    public String nuevoTicket (Model model){
        model.addAttribute("ticket", new Ticket());
        //usuario temporal
        return "nuevo-ticket";
    }

    @GetMapping ("/detalle-ticket")
    public String detalleTicket (){
        return "detalle-ticket-pendiente";
    }

    @GetMapping ("/historial-tickets")
    public String historialTickets (){
        return "historial-tickets";
    }

    @PostMapping ("/crear-ticket")
    //@ModelAttribute nos dice que el metodo recibe el objeto Ticket ya relleno con los datos que el usuario ingreso en los inputs.
    public String crearTicket (@ModelAttribute Ticket ticket){
        ticketService.guardarTicket(ticket);
        return "panel";
    }
}

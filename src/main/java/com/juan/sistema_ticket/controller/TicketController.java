package com.juan.sistema_ticket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.juan.sistema_ticket.model.Ticket;
import com.juan.sistema_ticket.service.TicketService;

@Controller
public class TicketController {
    
    @Autowired
    private TicketService ticketService;

    @GetMapping ("/nuevo-ticket")
    public String nuevoTicket (Model model){
        model.addAttribute("ticket", new Ticket());
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

  @GetMapping("/tickets-pendientes")
    public String ticketsPendientes(@RequestParam String palabraClave, Model model) {
    // 1. Preparamos una lista vacía por defecto
    List<Ticket> resultados = new ArrayList<>();

    try {
        // 2. Intentamos buscar por ID
        Long id = Long.parseLong(palabraClave);
        Ticket ticket = ticketService.obtenerPorId(id);
        // ¡OJO! Solo lo agregamos si NO es null (si existe)
        if (ticket != null) {
            resultados.add(ticket);
        }
        
    } catch (NumberFormatException e) {
        // 3. Si no era un número, buscamos por nombre
        resultados = ticketService.obtenerPorNombreCliente(palabraClave);
    }
        // 4. Sea lo que sea que hayamos encontrado (0, 1 o muchos), lo mandamos
        model.addAttribute("tickets", resultados);
        //model.addAttribute("palabraClave", palabraClave); // Opcional: para mostrar qué buscó el usuario

        return "historial-tickets";
    }

    @PostMapping ("/crear-ticket")
    //@ModelAttribute nos dice que el metodo recibe el objeto Ticket ya relleno con los datos que el usuario ingreso en los inputs.
    public String crearTicket (@ModelAttribute Ticket ticket){
        ticketService.guardarTicket(ticket);
        return "panel";
    }
}

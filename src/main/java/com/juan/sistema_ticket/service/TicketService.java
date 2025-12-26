package com.juan.sistema_ticket.service;

import com.juan.sistema_ticket.model.Ticket;
import com.juan.sistema_ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service // 1. Le dice a Spring: "Esta clase contiene la lógica de negocio"
public class TicketService {

    @Autowired // 2. Inyección de Dependencias: Trae el repositorio automáticamente
    private TicketRepository ticketRepository;

    // --- MÉTODOS DE LECTURA ---

    public List<Ticket> listarTodos() {
        return ticketRepository.findAll();
    }

    public Ticket obtenerPorId(Long id) {
        // findById devuelve un "Optional". Si no lo encuentra, devolvemos null
        return ticketRepository.findById(id).orElse(null);
    }

    public List<Ticket> obtenerPorNombreCliente (String nombreCliente){
        return ticketRepository.findByClienteNombreIgnoreCase(nombreCliente);
    }

    // --- MÉTODOS DE ESCRITURA ---

    public void guardarTicket(Ticket ticket) {

        ticketRepository.save(ticket);
    }

    public void eliminarTicket(Long id) {
        ticketRepository.deleteById(id);
    }
    
    // Un método con lógica especial
    public void cerrarTicket(Long id) {
        Ticket ticket = obtenerPorId(id);
        if (ticket != null) {
            ticket.setAbierto(false); // Falso = Cerrado
            ticket.setFechaCierre(LocalDate.now());
            ticketRepository.save(ticket); // Actualizamos en la BD
        }
    }
}

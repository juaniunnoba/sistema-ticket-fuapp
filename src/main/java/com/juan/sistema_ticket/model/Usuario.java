package com.juan.sistema_ticket.model;

import java.util.ArrayList;
import java.util.List;

import com.juan.sistema_ticket.enums.CategoriaEnum;
import com.juan.sistema_ticket.enums.EstadoEnum;
import com.juan.sistema_ticket.enums.RolEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private Long id;
    private String mail;
    private String apellido;
    private String nombre;
    private String telefono;
    private RolEnum rol;
    private List<Ticket> tickets;

    public Usuario (){
        tickets = new ArrayList <Ticket> ();
    }

    //crear un ticket
    public void abrirTicket (Usuario cliente, Usuario tecnico, String asunto, CategoriaEnum categoria){
        Ticket nuevoTicket = new Ticket(cliente, tecnico, asunto, categoria);
        tickets.add(nuevoTicket);
    }
    //agregar una evento
    public void agregarEvento (Ticket ticket, EstadoEnum estado, String descripcion){
        Evento nuevoEvento = new Evento(estado,descripcion);
        ticket.agregarEvento(nuevoEvento);
    }
    //buscar un ticket

}

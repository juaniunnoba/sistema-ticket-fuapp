package com.juan.sistema_ticket.model;

import java.util.ArrayList;
import java.util.List;

import com.juan.sistema_ticket.enums.CategoriaEnum;
import com.juan.sistema_ticket.enums.EstadoEnum;
import com.juan.sistema_ticket.enums.RolEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;
    private String nombre;
    private String telefono;
    @Enumerated(EnumType.STRING)
    private RolEnum rol;
    //un usuario puede generar muchos tickets.
    //luego se le dice cual va a ser la cf en la tabla tickets
    @OneToMany (mappedBy = "tecnicoAsignado")
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

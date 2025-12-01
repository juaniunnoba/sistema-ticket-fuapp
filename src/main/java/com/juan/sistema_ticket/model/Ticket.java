package com.juan.sistema_ticket.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.juan.sistema_ticket.enums.CategoriaEnum;
import com.juan.sistema_ticket.enums.EstadoEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
    
    private Long id;
    private Usuario cliente;
    private Usuario tecnicoAsignado;
    private String asunto;
    private boolean abierto;
    private LocalDate fechaApertura;
    private LocalDate fechaCierre;
    private CategoriaEnum categoria;
    private List <Evento> eventos;

    public Ticket (){
        eventos = new ArrayList <Evento> ();
    }

    public Ticket (Usuario cliente, Usuario tecnico, String asunto, CategoriaEnum categoria){
        this();
        this.abierto = true;
        this.tecnicoAsignado = tecnico;
        this.cliente = cliente;
        this.asunto = asunto;
        this.categoria = categoria;
        this.fechaApertura = LocalDate.now();
    }

    /*public Ticket abrirTicket (Usuario cliente, Usuario tecnico, String asunto, CategoriaEnum categoria){
        return new Ticket(cliente, tecnico, asunto, categoria);
    }*/

    public void agregarEvento (Evento nuevoEvento){
        eventos.add (nuevoEvento);
    }

}

package com.juan.sistema_ticket.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.juan.sistema_ticket.enums.CategoriaEnum;
import com.juan.sistema_ticket.enums.PrioridadEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ticket {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
  //a un cliente se le pueden cargar varios tickets
    @ManyToOne
    private Usuario cliente;
    //muchos tickets pertenencen a un técnico
    @ManyToOne
    private Usuario tecnicoAsignado;
    private String asunto;
    private String observaciones; 
    private boolean abierto;
    private LocalDate fechaApertura;
    private LocalDate fechaCierre;
    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;
    @Enumerated (EnumType.STRING)
    private PrioridadEnum prioridad;
    @OneToMany (mappedBy = "ticket")
    private List <Evento> eventos;

    public Ticket (){
        eventos = new ArrayList <Evento> ();
        this.fechaApertura = LocalDate.now();
        this.abierto = true;
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

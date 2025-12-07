package com.juan.sistema_ticket.model;

import java.time.LocalDate;

import com.juan.sistema_ticket.enums.EstadoEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Evento {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    //muchos eventos distintos pueden ser de un ticket
    @ManyToOne
    private Ticket ticket;
    private LocalDate fecha;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;

    public Evento (){}

    public Evento (EstadoEnum estado, String descripcion){
        this.fecha = LocalDate.now();
        this.estado = estado;
        this.descripcion = descripcion;
    }
}

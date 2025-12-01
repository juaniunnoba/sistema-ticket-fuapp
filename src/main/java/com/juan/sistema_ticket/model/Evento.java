package com.juan.sistema_ticket.model;

import java.time.LocalDate;

import com.juan.sistema_ticket.enums.EstadoEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Evento {
    private LocalDate fecha;
    private String descripcion;
    private EstadoEnum estado;

    public Evento (){}

    public Evento (EstadoEnum estado, String descripcion){
        this.fecha = LocalDate.now();
        this.estado = estado;
        this.descripcion = descripcion;
    }
}

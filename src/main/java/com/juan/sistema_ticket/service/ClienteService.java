package com.juan.sistema_ticket.service;

import org.springframework.stereotype.Service;

import com.juan.sistema_ticket.model.Usuario;

@Service
public class ClienteService {
    
    public void guardarCliente (Usuario cliente){
        System.out.println("cliente guardado ok");
    }
}

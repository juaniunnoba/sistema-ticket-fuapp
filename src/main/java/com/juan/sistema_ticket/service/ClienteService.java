package com.juan.sistema_ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juan.sistema_ticket.model.Usuario;
import com.juan.sistema_ticket.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;
    
    public void guardarCliente (Usuario cliente){
        clienteRepository.save(cliente);
    }
}

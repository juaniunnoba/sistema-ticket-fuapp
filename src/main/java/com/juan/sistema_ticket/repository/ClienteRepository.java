package com.juan.sistema_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juan.sistema_ticket.model.Usuario;

@Repository
public interface ClienteRepository extends JpaRepository<Usuario, Long> {
    
}

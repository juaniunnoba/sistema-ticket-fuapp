package com.juan.sistema_ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juan.sistema_ticket.model.Ticket;
import com.juan.sistema_ticket.model.Usuario;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // --- MÉTODOS MÁGICOS (Query Methods) ---
    // Spring crea el SQL automáticamente basándose en el nombre del método

    // 1. Buscar tickets asignados a un técnico específico
    List<Ticket> findByTecnicoAsignado(Usuario tecnico);

    // 3. Buscar solo los tickets que están abiertos (true) o cerrados (false)
    List<Ticket> findByAbierto(boolean estado);

    // 4. (Opcional) Combinar filtros: Tickets de un técnico que estén abiertos
    List<Ticket> findByTecnicoAsignadoAndAbierto(Usuario tecnico, boolean abiertoCerrado);

    List<Ticket> findByClienteNombreIgnoreCase(String palabraClave);
}

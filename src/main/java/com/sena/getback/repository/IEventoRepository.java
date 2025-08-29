package com.sena.getback.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.getback.model.Evento;

@Repository
public interface IEventoRepository extends JpaRepository <Evento, Integer> {
    
    Optional<Evento> findByNombre(String nombre);
    
    Optional<Evento> findByDescripcion(String descripcion);
    
}
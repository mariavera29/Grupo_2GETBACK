package com.sena.getback.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.getback.model.Bar;

@Repository
public interface IBarRepository extends JpaRepository<Bar, Integer> {
    
    Optional<Bar> findByPedidoId(Integer pedidoId);
    
    Optional<Bar> findByUsuarioId(Integer usuarioId);
    
    Optional<Bar> findByEstadoId(Integer estadoId);

}
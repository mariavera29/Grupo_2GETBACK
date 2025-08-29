package com.sena.getback.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.getback.model.Cocina;

@Repository
public interface ICocinaRepository extends JpaRepository<Cocina, Integer> {
    
    Optional<Cocina> findByPedidoId(Integer pedidoId);
    
    Optional<Cocina> findByUsuarioId(Integer usuarioId);
    
    Optional<Cocina> findByEstadoId(Integer estadoId);

}
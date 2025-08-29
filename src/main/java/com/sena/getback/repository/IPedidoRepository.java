package com.sena.getback.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.getback.model.Pedido;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {
    
    Optional<Pedido> findByNumeroMesa(Integer numeroMesa);
    
}
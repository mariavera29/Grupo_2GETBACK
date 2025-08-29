package com.sena.getback.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.getback.model.Inventario;

@Repository
public interface IInventarioRepository extends JpaRepository<Inventario, Integer> {
    
    Optional<Inventario> findByProducto(String producto);
    
    Optional<Inventario> findByRecibo(String recibo);
    
    Optional<Inventario> findByPrecio_compra(Double precio_compra);
    
}
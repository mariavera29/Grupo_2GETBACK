package com.sena.getback.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.getback.model.Estado;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Integer> {
    
    Optional<Estado> findByNombreEstado(String nombreEstado);

}
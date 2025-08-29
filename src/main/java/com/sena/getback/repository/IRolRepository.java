package com.sena.getback.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.getback.model.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    
    Optional<Rol> findByNombre(String nombre);
    
}
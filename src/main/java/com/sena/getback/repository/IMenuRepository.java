package com.sena.getback.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.getback.model.Menu;

@Repository
public interface IMenuRepository extends JpaRepository<Menu, Integer> {
    
    Optional<Menu> findByComida(String comida);
    
    Optional<Menu> findByCombo(String combo);
    
}
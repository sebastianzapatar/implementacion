package com.example.proyectospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.proyectospring.modelentity.Postre;

public interface IPostreDAO
        extends JpaRepository<Postre, Long>{
}

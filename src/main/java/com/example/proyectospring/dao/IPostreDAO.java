package com.example.proyectospring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.proyectospring.modelentity.Postre;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface IPostreDAO
        extends JpaRepository<Postre, Long>{
    public List<Postre> findByName(String name);
    public List<Postre> findByNameAndPrice(String name, Double price);
    public List<Postre> findByNameLike(String name);
    @Query("select p from Postre p where p.name like %?%")
    public List<Postre> findAllPostres(String nombre);
}

package com.example.proyectospring.dao;

import com.example.proyectospring.modelentity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPetDao extends JpaRepository<Pet, Long> {
    @Query("SELECT p FROM Pet p WHERE p.owner.id = :ownerId")
    List<Pet> findPetByOwnerId(@Param("ownerId") Long ownerId);
}

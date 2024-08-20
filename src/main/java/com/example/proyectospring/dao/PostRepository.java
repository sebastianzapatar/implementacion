package com.example.proyectospring.dao;

import com.example.proyectospring.modelentity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

}
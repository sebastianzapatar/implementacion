package com.example.proyectospring.dao;

import com.example.proyectospring.modelentity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.id = " +
            "(SELECT p.user.id FROM Post p GROUP BY p.user.id ORDER BY COUNT(p.id) DESC)")
    User findUserWithMostPosts();
    @Query("SELECT u FROM User u WHERE " +
            "(SELECT COUNT(p) FROM Post p WHERE p.user.id = u.id) < :postCount")
    List<User> findUsersWithLessThanPosts(@Param("postCount") Long postCount);
    // Aquí puedes agregar métodos personalizados si es necesario
}

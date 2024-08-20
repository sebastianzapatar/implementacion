package com.example.proyectospring.dao;

import com.example.proyectospring.modelentity.Person;
import com.example.proyectospring.modelentity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPeopleDao extends JpaRepository<Person, Long> {
}

package com.example.proyectospring.modelentity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.aspectj.weaver.patterns.PerObject;

@Data
@Entity
@Table(name="pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String breed;

    private int age;

    @ManyToOne()
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private Person owner;
}

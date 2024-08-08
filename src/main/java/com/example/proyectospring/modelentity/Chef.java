package com.example.proyectospring.modelentity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Entity
@Table(name="chefs")
@Data()
public class Chef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String name;

    @ManyToMany ()
    @JoinTable(
            name="chef_postre",
            joinColumns = @JoinColumn(name="chef_id"),
            inverseJoinColumns = @JoinColumn(name="postre_id")
    )
    private List<Postre> postres;

}

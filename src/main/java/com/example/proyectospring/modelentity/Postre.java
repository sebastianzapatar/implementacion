package com.example.proyectospring.modelentity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity()
@Table(name="postres")
@Data()
public class Postre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter()
    @Setter()
    private Long id;
    @Column()
    @Getter()
    @Setter()
    private Double price;
    @Column()
    @Getter()
    @Setter()
    private String name;

    @Column()
    @Getter()
    @Setter()
    private String description;
}

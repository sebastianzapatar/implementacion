package com.example.proyectospring.modelentity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity()
@Table(name="postres")
public class Postre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    @Getter()
    @Setter()
    @Min(1)
    private Double price;
    @Column()
    @Getter()
    @Setter()
    @Size(min = 5,max = 50,
            message = "Name Size must be between 5 and 50")
    private String name;
    @Column()
    @Getter()
    @Setter()
    private String description;

}

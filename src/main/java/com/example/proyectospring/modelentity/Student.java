package com.example.proyectospring.modelentity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    public void enrollInCourse(Course course) {
        this.courses.add(course);
    }

    public void withdrawFromCourse(Course course) {
        this.courses.remove(course);
    }
}

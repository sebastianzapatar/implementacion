package com.example.proyectospring.controllers;

import com.example.proyectospring.modelentity.Student;
import com.example.proyectospring.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Student>> getStudentsByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(studentService.findStudentsByCourseId(courseId));
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<Student> enrollStudentInCourse(@PathVariable Long studentId,
                                                         @PathVariable Long courseId) {
        System.out.println("Student ID: " + studentId);
        System.out.println("Course ID: " + courseId);

        return ResponseEntity.ok(studentService.enrollStudentInCourse(studentId, courseId));
    }

    @DeleteMapping("/{studentId}/withdraw/{courseId}")
    public ResponseEntity<Student> withdrawStudentFromCourse(@PathVariable Long studentId,
                                                             @PathVariable Long courseId) {
        return ResponseEntity.ok(studentService.withdrawStudentFromCourse(studentId, courseId));
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }
}

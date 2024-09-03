package com.example.proyectospring.services;

import com.example.proyectospring.dao.CourseRepository;
import com.example.proyectospring.dao.StudentRepository;
import com.example.proyectospring.modelentity.Course;
import com.example.proyectospring.modelentity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }
    public List<Student> findStudentsByCourseId(Long courseId) {
        return studentRepository.findStudentsByCourseId(courseId);
    }
    @Transactional
    public Student enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (!student.getCourses().contains(course)) {
            student.enrollInCourse(course);
            studentRepository.save(student);
        }
        else{
            throw new RuntimeException("Student already enrolled in course");
        }
        return student;
    }
    @Transactional
    public Student withdrawStudentFromCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (student.getCourses().contains(course)) {
            student.withdrawFromCourse(course);
            studentRepository.save(student);
        }

        return student;
    }
    @Transactional
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}

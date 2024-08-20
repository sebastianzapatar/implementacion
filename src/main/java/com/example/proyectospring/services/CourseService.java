package com.example.proyectospring.services;

import com.example.proyectospring.dao.CourseRepository;
import com.example.proyectospring.dao.StudentRepository;
import com.example.proyectospring.modelentity.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> findCoursesByStudentId(Long studentId) {
        return courseRepository.findCoursesByStudentId(studentId);
    }

    @Transactional
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}

package com.example.studentresult.service;

import com.example.studentresult.entity.Course;
import com.example.studentresult.entity.Enrollment;
import com.example.studentresult.entity.Student;
import com.example.studentresult.repository.CourseRepository;
import com.example.studentresult.repository.EnrollmentRepository;
import com.example.studentresult.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             StudentRepository studentRepository,
                             CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<Enrollment> getAll() { return enrollmentRepository.findAll(); }

    public List<Enrollment> byStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public Enrollment create(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return enrollmentRepository.save(new Enrollment(student, course));
    }

    public void delete(Long id) { enrollmentRepository.deleteById(id); }
}

package com.example.studentresult.service;

import com.example.studentresult.entity.Course;
import com.example.studentresult.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repository;
    public CourseService(CourseRepository repository) { this.repository = repository; }

    public List<Course> getAll() { return repository.findAll(); }
    public Course getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }
    public Course create(Course c) { return repository.save(c); }
    public Course update(Long id, Course input) {
        Course c = getById(id);
        c.setCode(input.getCode());
        c.setName(input.getName());
        c.setCredits(input.getCredits());
        c.setFacultyName(input.getFacultyName());
        return repository.save(c);
    }
    public void delete(Long id) { repository.deleteById(id); }
}

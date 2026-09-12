package com.example.studentresult.controller;

import com.example.studentresult.entity.Course;
import com.example.studentresult.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;
    public CourseController(CourseService service) { this.service = service; }

    @GetMapping public List<Course> all() { return service.getAll(); }
    @GetMapping("/{id}") public Course one(@PathVariable Long id) { return service.getById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Course create(@Valid @RequestBody Course course) { return service.create(course); }
    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @Valid @RequestBody Course course) {
        return service.update(id, course);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}

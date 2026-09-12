package com.example.studentresult.controller;

import com.example.studentresult.entity.Enrollment;
import com.example.studentresult.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService service;
    public EnrollmentController(EnrollmentService service) { this.service = service; }

    @GetMapping public List<Enrollment> all() { return service.getAll(); }
    @GetMapping("/student/{studentId}") public List<Enrollment> byStudent(@PathVariable Long studentId) {
        return service.byStudent(studentId);
    }

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Enrollment create(@RequestParam Long studentId, @RequestParam Long courseId) {
        return service.create(studentId, courseId);
    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}

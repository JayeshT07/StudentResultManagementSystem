package com.example.studentresult.controller;

import com.example.studentresult.entity.Attendance;
import com.example.studentresult.service.AttendanceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private final AttendanceService service;
    public AttendanceController(AttendanceService service) { this.service = service; }

    @GetMapping public List<Attendance> all() { return service.getAll(); }
    @GetMapping("/student/{studentId}") public List<Attendance> byStudent(@PathVariable Long studentId) {
        return service.byStudent(studentId);
    }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Attendance create(@Valid @RequestBody Attendance attendance) {
        return service.create(attendance);
    }
    @PutMapping("/{id}")
    public Attendance update(@PathVariable Long id, @Valid @RequestBody Attendance attendance) {
        return service.update(id, attendance);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}

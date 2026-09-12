package com.example.studentresult.service;

import com.example.studentresult.entity.Attendance;
import com.example.studentresult.repository.AttendanceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceService {
    private final AttendanceRepository repository;
    public AttendanceService(AttendanceRepository repository) { this.repository = repository; }
    public List<Attendance> getAll() { return repository.findAll(); }
    public List<Attendance> byStudent(Long studentId) { return repository.findByStudentId(studentId); }
    public Attendance create(Attendance attendance) { return repository.save(attendance); }
    public Attendance update(Long id, Attendance input) {
        Attendance a = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));
        a.setStudent(input.getStudent());
        a.setCourse(input.getCourse());
        a.setAttendanceDate(input.getAttendanceDate());
        a.setPresent(input.getPresent());
        return repository.save(a);
    }
    public void delete(Long id) { repository.deleteById(id); }
}

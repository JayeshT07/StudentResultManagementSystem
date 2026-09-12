package com.example.studentresult.service;

import com.example.studentresult.entity.Student;
import com.example.studentresult.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAll() { return repository.findAll(); }
    public Student getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }
    public Student create(Student student) { return repository.save(student); }
    public Student update(Long id, Student input) {
        Student s = getById(id);
        s.setFirstName(input.getFirstName());
        s.setLastName(input.getLastName());
        s.setEmail(input.getEmail());
        s.setRollNumber(input.getRollNumber());
        s.setSemester(input.getSemester());
        s.setDepartment(input.getDepartment());
        return repository.save(s);
    }
    public void delete(Long id) { repository.deleteById(id); }
}

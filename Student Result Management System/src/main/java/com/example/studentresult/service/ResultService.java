package com.example.studentresult.service;

import com.example.studentresult.entity.Result;
import com.example.studentresult.repository.ResultRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResultService {
    private final ResultRepository repository;
    public ResultService(ResultRepository repository) { this.repository = repository; }
    public List<Result> getAll() { return repository.findAll(); }
    public List<Result> byStudent(Long studentId) { return repository.findByStudentId(studentId); }
    public Result create(Result result) { return repository.save(result); }
    public Result update(Long id, Result input) {
        Result r = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));
        r.setStudent(input.getStudent());
        r.setCourse(input.getCourse());
        r.setMarks(input.getMarks());
        return repository.save(r);
    }
    public void delete(Long id) { repository.deleteById(id); }
}

package com.example.studentresult.controller;

import com.example.studentresult.entity.Result;
import com.example.studentresult.service.ResultService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {
    private final ResultService service;
    public ResultController(ResultService service) { this.service = service; }

    @GetMapping public List<Result> all() { return service.getAll(); }
    @GetMapping("/student/{studentId}") public List<Result> byStudent(@PathVariable Long studentId) {
        return service.byStudent(studentId);
    }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Result create(@Valid @RequestBody Result result) { return service.create(result); }
    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @Valid @RequestBody Result result) {
        return service.update(id, result);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}

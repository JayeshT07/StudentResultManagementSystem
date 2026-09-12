package com.example.studentresult.controller;

import com.example.studentresult.entity.Result;
import com.example.studentresult.repository.ResultRepository;
import com.example.studentresult.repository.AttendanceRepository;
import com.example.studentresult.entity.Attendance;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/students")
public class SummaryController {
    private final ResultRepository resultRepository;
    private final AttendanceRepository attendanceRepository;

    public SummaryController(ResultRepository resultRepository,
                             AttendanceRepository attendanceRepository) {
        this.resultRepository = resultRepository;
        this.attendanceRepository = attendanceRepository;
    }

    @GetMapping("/{studentId}/summary")
    public Map<String, Object> summary(@PathVariable Long studentId) {
        List<Result> results = resultRepository.findByStudentId(studentId);
        List<Attendance> attendance = attendanceRepository.findByStudentId(studentId);

        double average = results.stream()
                .mapToInt(Result::getMarks)
                .average()
                .orElse(0.0);

        long present = attendance.stream()
                .filter(a -> Boolean.TRUE.equals(a.getPresent()))
                .count();

        double attendancePercentage = attendance.isEmpty()
                ? 0.0
                : (present * 100.0 / attendance.size());

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("studentId", studentId);
        response.put("subjectsWithResults", results.size());
        response.put("averageMarks", Math.round(average * 100.0) / 100.0);
        response.put("attendanceRecords", attendance.size());
        response.put("attendancePercentage",
                Math.round(attendancePercentage * 100.0) / 100.0);
        return response;
    }
}

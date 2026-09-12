package com.example.studentresult.repository;
import com.example.studentresult.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByStudentId(Long studentId);
}

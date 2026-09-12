package com.example.studentresult.repository;
import com.example.studentresult.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long studentId);
}

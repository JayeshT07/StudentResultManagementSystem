package com.example.studentresult.repository;
import com.example.studentresult.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudentId(Long studentId);
}

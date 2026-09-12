package com.example.studentresult.repository;
import com.example.studentresult.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {}

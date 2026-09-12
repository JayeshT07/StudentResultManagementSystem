package com.example.studentresult.service;

import com.example.studentresult.entity.Announcement;
import com.example.studentresult.repository.AnnouncementRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnnouncementService {
    private final AnnouncementRepository repository;
    public AnnouncementService(AnnouncementRepository repository) { this.repository = repository; }
    public List<Announcement> getAll() { return repository.findAll(); }
    public Announcement create(Announcement a) { return repository.save(a); }
    public void delete(Long id) { repository.deleteById(id); }
}

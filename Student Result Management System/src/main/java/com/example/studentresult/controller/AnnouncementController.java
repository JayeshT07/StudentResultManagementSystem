package com.example.studentresult.controller;

import com.example.studentresult.entity.Announcement;
import com.example.studentresult.service.AnnouncementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {
    private final AnnouncementService service;
    public AnnouncementController(AnnouncementService service) { this.service = service; }

    @GetMapping public List<Announcement> all() { return service.getAll(); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Announcement create(@Valid @RequestBody Announcement announcement) {
        return service.create(announcement);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { service.delete(id); }
}

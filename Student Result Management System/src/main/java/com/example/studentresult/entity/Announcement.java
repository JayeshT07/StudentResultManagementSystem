package com.example.studentresult.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "announcements")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDateTime createdAt;

    @PrePersist
    public void setCreatedAt() {
        if (createdAt == null) createdAt = LocalDateTime.now();
    }

    public Announcement() {}

    public Announcement(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setMessage(String message) { this.message = message; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

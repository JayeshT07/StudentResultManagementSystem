package com.example.studentresult.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String code;

    @NotBlank
    @Column(nullable = false)
    private String name;

    private Integer credits;
    private String facultyName;

    public Course() {}

    public Course(String code, String name, Integer credits, String facultyName) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.facultyName = facultyName;
    }

    public Long getId() { return id; }
    public String getCode() { return code; }
    public String getName() { return name; }
    public Integer getCredits() { return credits; }
    public String getFacultyName() { return facultyName; }

    public void setId(Long id) { this.id = id; }
    public void setCode(String code) { this.code = code; }
    public void setName(String name) { this.name = name; }
    public void setCredits(Integer credits) { this.credits = credits; }
    public void setFacultyName(String facultyName) { this.facultyName = facultyName; }
}

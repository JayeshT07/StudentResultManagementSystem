package com.example.studentresult.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "results",
       uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "course_id"}))
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private Course course;

    @NotNull
    @Min(0)
    @Max(100)
    private Integer marks;

    private String grade;

    public Result() {}

    public Result(Student student, Course course, Integer marks) {
        this.student = student;
        this.course = course;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    @PrePersist
    @PreUpdate
    public void calculateGradeBeforeSave() {
        this.grade = calculateGrade(this.marks);
    }

    private String calculateGrade(Integer marks) {
        if (marks == null) return null;
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        if (marks >= 50) return "D";
        if (marks >= 40) return "E";
        return "F";
    }

    public Long getId() { return id; }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public Integer getMarks() { return marks; }
    public String getGrade() { return grade; }

    public void setId(Long id) { this.id = id; }
    public void setStudent(Student student) { this.student = student; }
    public void setCourse(Course course) { this.course = course; }
    public void setMarks(Integer marks) { this.marks = marks; }
    public void setGrade(String grade) { this.grade = grade; }
}

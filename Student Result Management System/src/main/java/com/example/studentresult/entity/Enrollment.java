package com.example.studentresult.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "enrollments",
       uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "course_id"}))
public class Enrollment {
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

    public Enrollment() {}

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Long getId() { return id; }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }

    public void setId(Long id) { this.id = id; }
    public void setStudent(Student student) { this.student = student; }
    public void setCourse(Course course) { this.course = course; }
}

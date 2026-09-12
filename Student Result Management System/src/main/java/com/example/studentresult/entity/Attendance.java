package com.example.studentresult.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "attendance")
public class Attendance {
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
    private LocalDate attendanceDate;

    @NotNull
    private Boolean present;

    public Attendance() {}

    public Attendance(Student student, Course course, LocalDate attendanceDate, Boolean present) {
        this.student = student;
        this.course = course;
        this.attendanceDate = attendanceDate;
        this.present = present;
    }

    public Long getId() { return id; }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public LocalDate getAttendanceDate() { return attendanceDate; }
    public Boolean getPresent() { return present; }

    public void setId(Long id) { this.id = id; }
    public void setStudent(Student student) { this.student = student; }
    public void setCourse(Course course) { this.course = course; }
    public void setAttendanceDate(LocalDate attendanceDate) { this.attendanceDate = attendanceDate; }
    public void setPresent(Boolean present) { this.present = present; }
}

package com.example.studentresult.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Column(nullable = false)
    private String lastName;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String rollNumber;

    @NotNull
    private Integer semester;

    private String department;

    public Student() {}

    public Student(String firstName, String lastName, String email, String rollNumber,
                   Integer semester, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rollNumber = rollNumber;
        this.semester = semester;
        this.department = department;
    }

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getRollNumber() { return rollNumber; }
    public Integer getSemester() { return semester; }
    public String getDepartment() { return department; }

    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }
    public void setSemester(Integer semester) { this.semester = semester; }
    public void setDepartment(String department) { this.department = department; }
}

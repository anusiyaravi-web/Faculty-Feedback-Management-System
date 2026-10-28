
package com.feedback.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "register_number", nullable = false)
    private String registerNumber;

    @Column(name = "faculty_name", nullable = false)
    private String facultyName;

    private Integer q1;
    private Integer q2;
    private Integer q3;
    private Integer q4;
    private Integer q5;
    private Integer q6;
    private Integer q7;
    private Integer q8;
    private Integer q9;
    private Integer q10;

    private String comments;

    @Column(name = "created_at",
            insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public Feedback() {
    }

    public Long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Integer getQ1() { return q1; }
    public void setQ1(Integer q1) { this.q1 = q1; }

    public Integer getQ2() { return q2; }
    public void setQ2(Integer q2) { this.q2 = q2; }

    public Integer getQ3() { return q3; }
    public void setQ3(Integer q3) { this.q3 = q3; }

    public Integer getQ4() { return q4; }
    public void setQ4(Integer q4) { this.q4 = q4; }

    public Integer getQ5() { return q5; }
    public void setQ5(Integer q5) { this.q5 = q5; }

    public Integer getQ6() { return q6; }
    public void setQ6(Integer q6) { this.q6 = q6; }

    public Integer getQ7() { return q7; }
    public void setQ7(Integer q7) { this.q7 = q7; }

    public Integer getQ8() { return q8; }
    public void setQ8(Integer q8) { this.q8 = q8; }

    public Integer getQ9() { return q9; }
    public void setQ9(Integer q9) { this.q9 = q9; }

    public Integer getQ10() { return q10; }
    public void setQ10(Integer q10) { this.q10 = q10; }

    public String getComments() { return comments; }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

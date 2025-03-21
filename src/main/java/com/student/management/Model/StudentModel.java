package com.student.management.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
//@Data
@Table(name = "Student_detail")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private int studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "STUDENT_NUMBER")
    private String studentNumber;

    @Column(name = "STUDENT_STATUS")
    private boolean studentStatus;

    @Column(name = "STUDENT_EMAIL_ID")
    private String studentEmailId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getStudentEmailId() {
        return studentEmailId;
    }

    public void setStudentEmailId(String studentEmailId) {
        this.studentEmailId = studentEmailId;
    }
}

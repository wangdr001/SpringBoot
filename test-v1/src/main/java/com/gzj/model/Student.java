package com.gzj.model;

public class Student {
    private Long studentId;

    private String studentName;

    private Long classId;

    private Integer studentGender;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Integer getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(Integer studentGender) {
        this.studentGender = studentGender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", classId=" + classId +
                ", studentGender=" + studentGender +
                '}';
    }
}
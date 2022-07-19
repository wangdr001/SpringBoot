package com.gzj.model;

public class Teacher {
    private Long teacherId;

    private String teacherName;

    private TeacherDetail teacherDetail;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public TeacherDetail getTeacherDetail() {
        return teacherDetail;
    }

    public void setTeacherDetail(TeacherDetail teacherDetail) {
        this.teacherDetail = teacherDetail;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherDetail=" + teacherDetail +
                '}';
    }
}
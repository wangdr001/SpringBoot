package com.gzj.model;

public class TeacherDetail {
    private Long teacherId;

    private String teacherGender;

    private Integer teacherAge;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    @Override
    public String toString() {
        return "TeacherDetail{" +
                "teacherId=" + teacherId +
                ", teacherGender='" + teacherGender + '\'' +
                ", teacherAge=" + teacherAge +
                '}';
    }
}
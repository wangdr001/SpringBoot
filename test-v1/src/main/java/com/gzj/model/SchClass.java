package com.gzj.model;

public class SchClass {
    private Long classId;

    private String className;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "SchClass{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                '}';
    }
}
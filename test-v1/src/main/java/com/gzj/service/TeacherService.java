package com.gzj.service;

import com.gzj.model.Teacher;

public interface TeacherService {

    int saveAddTeacher(Teacher teacher);

    int saveEditTeacher(Teacher teacher);

    int deleteTeacherByName(String name);

    Teacher queryTeacherDetailById (String id);
}

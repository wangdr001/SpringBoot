package com.gzj.service.impl;

import com.gzj.dao.TeacherMapper;
import com.gzj.model.Teacher;
import com.gzj.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public int saveAddTeacher(Teacher teacher) {

        return teacherMapper.insertTeacher(teacher);
    }

    @Override
    public int saveEditTeacher(Teacher teacher) {

        return teacherMapper.updateTeacher(teacher); }

    @Override
    public int deleteTeacherByName(String name) {

        return teacherMapper.deleteTeacherByName(name);
    }

    @Override
    public Teacher queryTeacherDetailById(String id) {

        return teacherMapper.selectTeacherDetailById(id);
    }

}
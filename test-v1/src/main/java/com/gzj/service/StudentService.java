package com.gzj.service;

import com.github.pagehelper.PageInfo;
import com.gzj.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    PageInfo<Student> queryStudentByConditionForPage(Map<String,Object> map, int pageNum, int pageSize);

    int saveAddStudent(Student student);

    int saveEditStudent(Student student);

    int deleteStudentByName(String name);

    List<Student> queryStudentByTeacherId (String id);

    List<Student> queryStudentByClassIds (String[] ids); 
}

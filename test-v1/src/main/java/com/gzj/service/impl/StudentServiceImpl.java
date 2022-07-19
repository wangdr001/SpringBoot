package com.gzj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gzj.dao.StudentMapper;
import com.gzj.model.Student;
import com.gzj.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;

    // 多个查询(分页）
    @Override
    public PageInfo<Student> queryStudentByConditionForPage(Map<String, Object> map, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Student> list =studentMapper.selectStudentByCondition(map);
        PageInfo<Student> result = new PageInfo<Student>(list);
        return result;
    }

    @Override
    public int saveAddStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public int saveEditStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int deleteStudentByName(String name) {
        return studentMapper.deleteStudentByName(name);
    }

    @Override
    public List<Student> queryStudentByTeacherId(String id) {
        return studentMapper.selectStudentByTeacherId(id);
    }

    @Override
    public List<Student> queryStudentByClassIds(String[] ids) {
        return studentMapper.selectStudentByClassIds(ids);
    }
}

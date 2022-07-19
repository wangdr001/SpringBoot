package com.gzj.dao;

import com.gzj.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    int deleteByPrimaryKey(Long studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    /**
     * 	2. 学生
     * 	1. 条件分页查询，方法名/student/list，请求方式get，查询条件
     * 		- name模糊匹配
     * 		- class_id精确匹配
     * 		- gender精确匹配
     * 	2. 新增，方法名/student/add，请求方式post，参数放在请求体中
     * 	3. 修改，方法名/student/edit，请求方式put，参数放在请求体中
     * 	4. 删除，方法名/student/delete，请求方式delete，参数放在请求上
     */
    List<Student> selectStudentByCondition(Map<String,Object> map);

    int insertStudent(Student student);

    int updateStudent(Student student);

    int deleteStudentByName(@Param("studentName") String name);

    /**
     * 4. 根据教师id查询该教师所有的学生的信息
     * 	方法名/student/getByTeacherId，请求方式get，要求使用restFul传参
     */
    List<Student> selectStudentByTeacherId (@Param("teacherId") String id);

    /**
     * 6. 根据班级id的集合查询这些班级中所有学生的信息
     * 	方法名/student/getByClassIds，请求方式get，要求后台接收参数时用List接收
     */
    List<Student> selectStudentByClassIds (@Param("classIds") String[] ids);


}
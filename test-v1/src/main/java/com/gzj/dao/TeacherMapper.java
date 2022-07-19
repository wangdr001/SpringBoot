package com.gzj.dao;

import com.gzj.model.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    int deleteByPrimaryKey(Long teacherId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long teacherId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    /**
     * 	3. 教师
     * 	1. 新增，方法名/teacher/add，请求方式post，参数放在请求体中
     * 	2. 修改，方法名/teacher/edit，请求方式put，参数放在请求体中
     * 	3. 删除，方法名/teacher/delete，请求方式delete，参数放在请求上
     */
    int insertTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    int deleteTeacherByName(@Param("teacherName") String name);

    /**
     *  5. 根据教师id查询该教师的详情
     *     方法名/teacher/findOne，请求方式get，要求使用restFul传参
     */
    Teacher selectTeacherDetailById (@Param("teacherId") String id);

}
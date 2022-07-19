package com.gzj.dao;

import com.gzj.model.TeacherDetail;

public interface TeacherDetailMapper {
    int deleteByPrimaryKey(Long teacherId);

    int insert(TeacherDetail record);

    int insertSelective(TeacherDetail record);

    TeacherDetail selectByPrimaryKey(Long teacherId);

    int updateByPrimaryKeySelective(TeacherDetail record);

    int updateByPrimaryKey(TeacherDetail record);

    int insertTeacherDetail(TeacherDetail teacherDetail);

}
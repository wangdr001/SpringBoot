package com.gzj.service.impl;

import com.gzj.dao.TeacherDetailMapper;
import com.gzj.model.TeacherDetail;
import com.gzj.service.TeacherDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherDetailServiceImpl implements TeacherDetailService {

    @Resource
    private TeacherDetailMapper teacherDetailMapper;

    @Override
    public int saveAddTeacherDetail(TeacherDetail teacherDetail) {
        return teacherDetailMapper.insertTeacherDetail(teacherDetail);
    }
}

package com.gzj.service.impl;

import com.gzj.dao.SchClassMapper;
import com.gzj.model.SchClass;
import com.gzj.service.SchClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SchClassServiceImpl implements SchClassService {

    @Resource
    SchClassMapper schClassMapper;

    @Override
    public int saveAddSchClass(SchClass schClass) {

        return schClassMapper.insertSchClass(schClass);
    }

    @Override
    public int saveEditSchClass(SchClass schClass) {

        return schClassMapper.updateSchClass(schClass);
    }

    @Override
    public int deleteClassByNumber(String name) {

        return schClassMapper.deleteClassByNumber(name);
    }
}

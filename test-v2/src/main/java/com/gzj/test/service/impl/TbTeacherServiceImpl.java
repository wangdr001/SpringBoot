package com.gzj.test.service.impl;

import com.gzj.test.entity.TbTeacher;
import com.gzj.test.mapper.TbTeacherMapper;
import com.gzj.test.service.TbTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangdr
 * @since 2022-07-16
 */
@Service
public class TbTeacherServiceImpl extends ServiceImpl<TbTeacherMapper, TbTeacher> implements TbTeacherService {

    @Resource
    private TbTeacherMapper tbTeacherMapper;

    @Override
    public int addTeacher(TbTeacher teacher) {
        return tbTeacherMapper.insert(teacher);
    }

    @Override
    public int editTeacherById(TbTeacher teacher) {
        return tbTeacherMapper.updateById(teacher);
    }

    @Override
    public int deleteTeacherById(Long id) {
        return tbTeacherMapper.deleteById(id);
    }

    @Override
    public TbTeacher queryTeacherDetailById(Long id) {
        return tbTeacherMapper.selectTeacherDetailById(id);
    }
}

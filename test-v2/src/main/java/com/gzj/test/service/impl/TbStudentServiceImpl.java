package com.gzj.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzj.test.entity.TbStudent;
import com.gzj.test.mapper.TbStudentMapper;
import com.gzj.test.service.TbStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangdr
 * @since 2022-07-16
 */
@Service
public class TbStudentServiceImpl extends ServiceImpl<TbStudentMapper, TbStudent> implements TbStudentService {

    @Resource
    private TbStudentMapper tbStudentMapper;

    @Override
    public Page<TbStudent> queryStudentByConditionForPage(Page<TbStudent> page, QueryWrapper<TbStudent> qw) {
        return tbStudentMapper.selectPage(page,qw);
    }

    @Override
    public int addStudent(TbStudent student) { return tbStudentMapper.insert(student);
    }

    @Override
    public int editStudentById(TbStudent student) {
        return tbStudentMapper.updateById(student);
    }

    @Override
    public int deleteStudentById(Long id) {
        return tbStudentMapper.deleteById(id);
    }

    @Override
    public List<TbStudent> queryStudentByTeacherId(Long id) {
        return tbStudentMapper.selectStudentByTeacherId(id);
    }

    @Override
    public List<TbStudent> queryStudentByClassIds(Long[] id) {
        QueryWrapper<TbStudent> qw = new QueryWrapper<>();
        qw.in("class_id", id );
        return tbStudentMapper.selectList(qw);
    }

}

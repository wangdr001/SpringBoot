package com.gzj.test.service.impl;

import com.gzj.test.entity.TbTeacherDetail;
import com.gzj.test.mapper.TbTeacherDetailMapper;
import com.gzj.test.service.TbTeacherDetailService;
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
public class TbTeacherDetailServiceImpl extends ServiceImpl<TbTeacherDetailMapper, TbTeacherDetail> implements TbTeacherDetailService {

    @Resource
    private TbTeacherDetailMapper tbTeacherDetailMapper;

    @Override
    public int addTeacherDetail(TbTeacherDetail teacherDetail) {
        return tbTeacherDetailMapper.insert(teacherDetail);
    }
}

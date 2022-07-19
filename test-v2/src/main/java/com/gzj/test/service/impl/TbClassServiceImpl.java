package com.gzj.test.service.impl;

import com.gzj.test.entity.TbClass;
import com.gzj.test.mapper.TbClassMapper;
import com.gzj.test.service.TbClassService;
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
public class TbClassServiceImpl extends ServiceImpl<TbClassMapper, TbClass> implements TbClassService {

    @Resource
    private TbClassMapper tbClassMapper;

    @Override
    public int addClass(TbClass tbClass) {
        return tbClassMapper.insert(tbClass);
    }

    @Override
    public int editClassById(TbClass tbClass) {
        return tbClassMapper.updateById(tbClass);
    }

    @Override
    public int deleteClassById(Long id) {
        return tbClassMapper.deleteById(id);
    }
}

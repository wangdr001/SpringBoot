package com.gzj.test.service;

import com.gzj.test.entity.TbClass;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangdr
 * @since 2022-07-16
 */
public interface TbClassService extends IService<TbClass> {

    int addClass(TbClass tbClass);

    int editClassById(TbClass tbClass);

    int deleteClassById(Long id);

}

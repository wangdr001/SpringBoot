package com.gzj.test.service;

import com.gzj.test.entity.TbTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangdr
 * @since 2022-07-16
 */
public interface TbTeacherService extends IService<TbTeacher> {

    int addTeacher(TbTeacher teacher);

    int editTeacherById(TbTeacher teacher);

    int deleteTeacherById(Long id);

    TbTeacher queryTeacherDetailById (Long id);

}

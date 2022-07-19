package com.gzj.test.service;

import com.gzj.test.entity.TbTeacherDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangdr
 * @since 2022-07-16
 */
public interface TbTeacherDetailService extends IService<TbTeacherDetail> {

    int addTeacherDetail(TbTeacherDetail teacherDetail);
}

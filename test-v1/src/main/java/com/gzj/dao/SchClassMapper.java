package com.gzj.dao;

import com.gzj.model.SchClass;
import org.apache.ibatis.annotations.Param;

public interface SchClassMapper {
    int deleteByPrimaryKey(Long classId);

    int insert(SchClass record);

    int insertSelective(SchClass record);

    SchClass selectByPrimaryKey(Long classId);

    int updateByPrimaryKeySelective(SchClass record);

    int updateByPrimaryKey(SchClass record);

    /**
     * 1. 班级
     * 	1. 新增，方法名/class/add，请求方式post，参数放在请求体中
     * 	2. 修改，方法名/class/edit，请求方式put，参数放在请求体中
     * 	3. 删除，方法名/class/delete，请求方式delete，参数放在请求上
     */
    int insertSchClass(SchClass schClass);

    int updateSchClass(SchClass schClass);

    int deleteClassByNumber(@Param("className") String name);
}
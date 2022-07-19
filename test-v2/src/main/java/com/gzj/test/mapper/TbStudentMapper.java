package com.gzj.test.mapper;

import com.gzj.test.entity.TbStudent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangdr
 * @since 2022-07-16
 */
public interface TbStudentMapper extends BaseMapper<TbStudent> {

    @Select("<script>" +
            "   select a.id,name,gender,class_id " +
            "     from tb_student a, tb_teacher_student b " +
            "     where a.id = b.student_id and b.teacher_id = #{teacherId} " +
            "</script>")
    List<TbStudent> selectStudentByTeacherId (@Param("teacherId") Long id);

}

package com.gzj.test.mapper;

import com.gzj.test.entity.TbTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzj.test.entity.TbTeacherDetail;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wangdr
 * @since 2022-07-16
 */
public interface TbTeacherMapper extends BaseMapper<TbTeacher> {

    @Select("<script>" +
            "   select a.id, a.name, b.gender, b.age " +
            "     from tb_teacher a, tb_teacher_detail b " +
            "     where a.id = b.teacherId and a.id = #{teacherId} " +
            "</script>")
    @Results(id="studentMap", value={
            @Result(column="id", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="id", property="tbTeacherDetail", javaType= TbTeacherDetail.class,
                    one=@One(select="com.gzj.test.mapper.TbTeacherDetailMapper.selectById"))
    })
    TbTeacher selectTeacherDetailById (@Param("teacherId") Long id);

}

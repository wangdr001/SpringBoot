package com.gzj.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(
        value = "tb_teacher_detail"
)
public class TbTeacherDetail implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * tb_teacher表中的主键
     */
    @TableId(value = "teacherId", type = IdType.AUTO)
    private Long teacherId;

    /**
     * 性别，1男，2女
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

}

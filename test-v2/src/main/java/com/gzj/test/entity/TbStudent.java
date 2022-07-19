package com.gzj.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(
        value = "tb_student"
)
public class TbStudent implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 班级id
     */
    @TableField(value = "class_id")
    private Long classId;

    /**
     * 性别，1男，2女
     */
    private Integer gender;

}

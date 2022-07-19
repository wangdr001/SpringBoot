package com.gzj.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.annotation.Resource;
import java.io.Serializable;

@Data
@TableName(
        value = "tb_teacher"
)
public class TbTeacher implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    @TableField(exist = false)
    private TbTeacherDetail tbTeacherDetail;
}

package com.gzj.test.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzj.test.entity.TbStudent;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangdr
 * @since 2022-07-16
 */
public interface TbStudentService extends IService<TbStudent> {

    /**
     * 原始类型: boolean，char，byte，short，int，long，float，double
     *
     * 包装类型：Boolean，Character，Byte，Short，Integer，Long，Float，Double
     *
     * 基本类型和包装类型的区别主要有以下 几点：
     *
     * 包装类型可以为 null，而基本类型不可以。它使得包装类型可以应用于 POJO 中，而基本类型则不行。那为什么 POJO 的属性必须要用包装类型呢？
     * 《阿里巴巴 Java 开发手册》上有详细的说明， 数据库的查询结果可能是 null，如果使用基本类型的话，因为要自动拆箱（将包装类型转为基本类型，
     *  比如说把 Integer 对象转换成 int 值），就会抛出 NullPointerException 的异常。
     *
     * 包装类型可用于泛型，而基本类型不可以。泛型不能使用基本类型，因为使用基本类型时会编译出错。
     *
     * List<int> list = new ArrayList<>(); // 提示 Syntax error, insert "Dimensions" to complete ReferenceType
     * List<Integer> list = new ArrayList<>();
     * 因为泛型在编译时会进行类型擦除，最后只保留原始类型，而原始类型只能是 Object 类及其子类——基本类型是个特例。
     *
     * 基本类型比包装类型更高效。基本类型在栈中直接存储的具体数值，而包装类型则存储的是堆中的引用。 很显然，相比较于基本类型而言，包装类型需要占用更多的内存空间。
     */

    Page<TbStudent> queryStudentByConditionForPage(Page<TbStudent> page, QueryWrapper<TbStudent> qw);

    int addStudent(TbStudent student);

    int editStudentById(TbStudent student);

    int deleteStudentById(Long id);

    List<TbStudent> queryStudentByTeacherId (Long id);

    List<TbStudent> queryStudentByClassIds (Long[] id);

}

package com.gzj.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gzj.test.entity.TbStudent;
import com.gzj.test.service.TbStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class TbStudentController {

    @Resource
    private TbStudentService tbStudentService;

    /**
     * 	1. 条件分页查询，方法名/student/list，请求方式get，查询条件
     * 		- name模糊匹配
     * 		- class_id精确匹配
     * 		- gender精确匹配
     */
    @GetMapping("/queryStudentByConditionForPage/student/list")
    public Object queryStudentByConditionForPage(String name, String id, String gender,
                                                 int pageNum, int pageSize){
        QueryWrapper<TbStudent> qw = new QueryWrapper<>();
        //多条件组合查询
        //判断条件值是否为空,如果不为空拼接条件
        if (!StringUtils.isEmpty(name)){
            //构建条件 模糊查询
            qw.like("name",name);
        }

        if (!StringUtils.isEmpty(id)){
            //等于
            qw.eq("class_id",id);
        }

        if (!StringUtils.isEmpty(gender)){
            //等于
            qw.eq("gender",gender);
        }

        //创建Page对象
        Page<TbStudent> page  = new Page<>();
        //设置分页的数据
        page.setCurrent(pageNum);//第一页
        page.setSize(pageSize);// 每页的记录数

        Page<TbStudent> result = tbStudentService.queryStudentByConditionForPage(page,qw);

        //获取分页后的记录
        List<TbStudent> students = result.getRecords();
        //分页的信息
        log.info("总记录数："+result.getTotal());
        log.info("页数："+result.getPages());
        log.info("当前页码："+result.getCurrent());
        return students ;
    }

    /**
     * 	2. 新增，方法名/student/add，请求方式post，参数放在请求体中
     * 	3. 修改，方法名/student/edit，请求方式put，参数放在请求体中
     * 	4. 删除，方法名/student/delete，请求方式delete，参数放在请求上
     */
    @PostMapping(value = "/AddStudent/student/add")
    public Object AddStudent(@RequestBody TbStudent student ){
        int insert = tbStudentService.addStudent(student);
        return "新增"+student+"返回"+insert;
    }

    @PutMapping(value = "/saveEditStudent/student/edit")
    public Object saveEditStudent(@RequestBody TbStudent student){
        int update = tbStudentService.editStudentById(student);
        return "修改"+student+"返回"+update;
    }

    @DeleteMapping(value = "/deleteStudentByName/student/delete")
    public Object deleteStudentByName(@RequestParam Long id){
        int delete = tbStudentService.deleteStudentById(id);
        return "删除"+id+"返回"+delete;
    }

    /**
     *  4. 根据教师id查询该教师所有的学生的信息
     *  	方法名/student/getByTeacherId，请求方式get，要求使用rest
     */
    @GetMapping(value = "/queryStudentByTeacherId/student/getByTeacherId")
    public Object queryStudentByTeacherId(HttpServletRequest request){
        String id = request.getParameter("id");
        return tbStudentService.queryStudentByTeacherId(Long.valueOf(id));
    }

    /**
     * 6. 根据班级id的集合查询这些班级中所有学生的信息
     *     方法名/student/getByClassIds，请求方式get，要求后台接收参数时用
     */
    @GetMapping(value = "/queryStudentByClassId/student/getByClassIds")
    public Object queryStudentByClassIds(Long[] id){
        return tbStudentService.queryStudentByClassIds(id);
    }

}

